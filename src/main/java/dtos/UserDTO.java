package dtos;

import entities.Music;
import entities.Quiz;
import entities.Role;
import entities.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class UserDTO {

    private int userID;
    private String username;
    private String email;
    private String password;
    private Role role;
    private List<Quiz> createdQuizzes = new ArrayList<>();
    private List<Quiz> playedQuizzes = new ArrayList<>();
    private List<Music> bookmarkedSongs = new ArrayList<>();


    public UserDTO() {
    }

    public UserDTO(User user) {
        this.userID = user.getUserID();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.role = user.getRole();
        this.createdQuizzes = user.getCreatedQuizzes();
        this.playedQuizzes = user.getPlayedQuizzes();
        this.bookmarkedSongs = user.getBookmarkedSongs();
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

    public void setCreatedQuizzes(List<Quiz> createdQuizzes) {
        this.createdQuizzes = createdQuizzes;
    }

    public List<Quiz> getPlayedQuizzes() {
        return playedQuizzes;
    }

    public void setPlayedQuizzes(List<Quiz> playedQuizzes) {
        this.playedQuizzes = playedQuizzes;
    }

    public List<Music> getBookmarkedSongs() {
        return bookmarkedSongs;
    }

    public void setBookmarkedSongs(List<Music> bookmarkedSongs) {
        this.bookmarkedSongs = bookmarkedSongs;
    }
}
