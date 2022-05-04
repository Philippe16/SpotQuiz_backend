package entities;

import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false, unique = true)
    private int userID;

    @Basic(optional = false)
    @Column(name = "username", nullable = false)
    private String username;

    @Basic(optional = false)
    @Column(name = "email", nullable = false)
    private String email;

    @Basic(optional = false)
    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "fk_role", nullable = false)
    private Role role;

    @ManyToMany
    @JoinTable(name = "created_quizzes", joinColumns = {
            @JoinColumn(name = "fk_user_id", referencedColumnName = "user_id")}, inverseJoinColumns = {
            @JoinColumn(name = "fk_quiz_id", referencedColumnName = "quiz_id")}
    )
    private List<Quiz> createdQuizzes = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "played_quizzes", joinColumns = {
            @JoinColumn(name = "fk_user_id", referencedColumnName = "user_id")}, inverseJoinColumns = {
            @JoinColumn(name = "fk_quiz_id", referencedColumnName = "quiz_id")}
    )
    private List<Quiz> playedQuizzes = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "bookmarked_songs", joinColumns = {
            @JoinColumn(name = "fk_user_id", referencedColumnName = "user_id")}, inverseJoinColumns = {
            @JoinColumn(name = "fk_music_id", referencedColumnName = "music_id")}
    )
    private List<Music> bookmarkedSongs = new ArrayList<>();

    public User() {
    }

    public User(String username, String email, String password, Role role) {
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
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
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

    public String getRoleAsString(){
        return this.getRole().getRoleName();
    }

}
