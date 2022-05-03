package entities;

import org.mindrot.jbcrypt.BCrypt;
import utils.EMF_Creator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "users")
public class User2 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "user_id", nullable = false)
    private int userID;

    @Basic(optional = false)
    @Size(max = 250)
    @Column(name = "username", nullable = false)
    private String username;

    @Basic(optional = false)
    @Size
    @Column(name = "email", nullable = false)
    private String email;

    @Basic(optional = false)
    @Size
    @Column(name = "password", nullable = false)
    private String password;


    @ManyToOne
    @JoinColumn(name = "fk_role", nullable = false)
    private Role role;

    @ManyToMany
    @JoinTable(name = "created_quizzes", joinColumns = {
            @JoinColumn(name = "fk_user_id", referencedColumnName = "user_id")}, inverseJoinColumns = {
            @JoinColumn(name = "fk_quiz_id", referencedColumnName = "role_name")}
    )
    private List<Quiz> createdQuizzes = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "played_quizzes", joinColumns = {
            @JoinColumn(name = "fk_user_id", referencedColumnName = "user_id")}, inverseJoinColumns = {
            @JoinColumn(name = "fk_quiz_id", referencedColumnName = "role_name")}
    )
    private List<Quiz> playedQuizzes = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "bookmarked_songs", joinColumns = {
            @JoinColumn(name = "fk_user_id", referencedColumnName = "user_id")}, inverseJoinColumns = {
            @JoinColumn(name = "fk_music_id", referencedColumnName = "music_id")}
    )
    private List<Music> bookmarkedSongs = new ArrayList<>();

    public User2() {
    }

    public User2(String username, String email, String password, Role role) {
        this.username = username;
        this.email = email;
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
        this.role = role;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Quiz> getCreatedQuizzes() {
        return createdQuizzes;
    }

    public void setCreatedQuizzes(List<Quiz> quizzes) {
        this.createdQuizzes = quizzes;
    }

    public List<Music> getBookmarkedSongs() {
        return bookmarkedSongs;
    }

    public void setBookmarkedSongs(List<Music> bookmarkedSongs) {
        this.bookmarkedSongs = bookmarkedSongs;
    }

    public List<Quiz> getPlayedQuizzes() {
        return playedQuizzes;
    }

    public void setPlayedQuizzes(List<Quiz> playedQuizzes) {
        this.playedQuizzes = playedQuizzes;
    }

    public boolean verifyPassword(String plainPassword) {
        return (BCrypt.checkpw(plainPassword, password));
    }

    public static void main(String[] args) {
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        Role role = new Role("user");
        User2 user = new User2("test_user1", "test@gmail.com", "secret", role);

        em.getTransaction().begin();
            em.persist(role);
            em.persist(user);
        em.getTransaction().commit();

        // Er kommet lidt nærmere problemet, tror jeg.

        // Den brokker sig over at vi ikke giver column user_name en værdi
        // Men vores user har ikke en column kaldet user_name...
        // Så tror at fejlen ligger et andet sted, ja den tager fejl af vores user.. Den tager user og ikke user2
        // Inde i User (ikke vores som er User2), der har den en user_name
        // Men ja, undrer mig lidt over det...
        // Har lyst til at slette User xD
        // Men der kommer sikkert til at opstå nogle fejl, fordi den har test...
        // Kunne du commit og push og merge til main?
        // Så kan vi efterfølgende prøve at slette User og hvad der ellers medfølger
        // kan jeg godt, kan ikke lige se hvorfor den gør det :/

    }

}