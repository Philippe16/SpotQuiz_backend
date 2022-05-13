package facades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

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
     *
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

    public User getVeryfiedUser(String username, String password) throws AuthenticationException {
        EntityManager em = emf.createEntityManager();
        User user;
        try {
            user = em.find(User.class, username);
            if (user == null || !user.verifyPassword(password)) {
                throw new AuthenticationException("Invalid username or password");
            }
        } finally {
            em.close();
        }
        return user;
    }

    public UserDTO createAccount(NewUserDTO newUserDTO){
        EntityManager em = emf.createEntityManager();
        User user;
        UserDTO userDTO = null;

        try{
            user = em.find(User.class, newUserDTO.getUsername());

            if(user == null){
                Role role = em.find(Role.class, "user");

                if(role == null){
                    Role userRole = new Role("user");
                    em.persist(new Role(userRole.getRoleName()));
                    em.flush();
                    role = userRole;
                }

                user = new User(newUserDTO.getUsername(), newUserDTO.getEmail(), newUserDTO.getPassword(), role);

                em.getTransaction().begin();
                    em.persist(user);
                em.getTransaction().commit();

                userDTO = new UserDTO(em.find(User.class, newUserDTO.getUsername()));
            }
        }finally{
            em.close();
        }

        return userDTO;
    }
}
