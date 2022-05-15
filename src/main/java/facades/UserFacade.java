package facades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import dtos.NewUserDTO;
import dtos.UserDTO;
import entities.Role;
import entities.User;
import security.errorhandling.AuthenticationException;

/**
 * @author lam@cphbusiness.dk
 */
public class UserFacade {
    private static EntityManagerFactory emf;
    private static UserFacade instance;

    private UserFacade() {
    }

    /**
     * @param _emf
     * @return the instance of this facade.
     */
    public static UserFacade getUserFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new UserFacade();
        }

        return instance;
    }

    public User getVeryfiedUser(String email, String password) throws AuthenticationException {
        EntityManager em = emf.createEntityManager();
        User user;

        try {
            user = getUserByEmail(em, email);

            if (!user.verifyPassword(password)) {
                throw new AuthenticationException("Invalid email or password");
            }
        }catch(NoResultException ignored){
            throw new AuthenticationException("Invalid email or password");
        } finally {
            em.close();
        }
        return user;
    }

    public UserDTO createAccount(NewUserDTO newUserDTO) {
        EntityManager em = emf.createEntityManager();
        User user;
        UserDTO userDTO = null;

        try {
            user = getUserByEmail(em, newUserDTO.getEmail());
        } catch (NoResultException ex) {
            Role role = em.find(Role.class, "user");

            if (role == null) {
                Role userRole = new Role("user");

                em.getTransaction().begin();
                em.persist(new Role(userRole.getRoleName()));
                em.getTransaction().commit();

                role = userRole;
            }

            user = new User(newUserDTO.getUsername(), newUserDTO.getEmail(), newUserDTO.getPassword(), role);

            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();

            userDTO = new UserDTO(getUserByEmail(em, newUserDTO.getEmail()));
        } finally {
            em.close();
        }

        return userDTO;
    }

    public User getUserByEmail(EntityManager em, String email) throws NoResultException{
        TypedQuery<User> query = em.createQuery("SELECT user FROM User AS user WHERE user.email = :email", User.class);
        query.setParameter("email", email);

        return query.getSingleResult();
    }

}
