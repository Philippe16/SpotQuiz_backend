package dtos;

import entities.Music;
import entities.Quiz;
import entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {
    private int userID;
    private String username;
    private String email;
    private String password;
    private RoleDTO role;
    private List<QuizDTO> createdQuizzes = new ArrayList<>();
    private List<QuizDTO> playedQuizzes = new ArrayList<>();
    private List<MusicDTO> bookmarkedSongs = new ArrayList<>();

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.userID = user.getUserID();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.role = new RoleDTO(user.getRole());

        for(Quiz quiz : user.getCreatedQuizzes()){
            createdQuizzes.add(new QuizDTO(quiz));
        }

        for(Quiz quiz : user.getPlayedQuizzes()){
            createdQuizzes.add(new QuizDTO(quiz));
        }

        for(Music music : user.getBookmarkedSongs()){
            bookmarkedSongs.add(new MusicDTO(music));
        }
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

    public RoleDTO getRole() {
        return role;
    }

    public void setRole(RoleDTO role) {
        this.role = role;
    }

    public List<QuizDTO> getCreatedQuizzes() {
        return createdQuizzes;
    }

    public void setCreatedQuizzes(List<QuizDTO> createdQuizzes) {
        this.createdQuizzes = createdQuizzes;
    }

    public List<QuizDTO> getPlayedQuizzes() {
        return playedQuizzes;
    }

    public void setPlayedQuizzes(List<QuizDTO> playedQuizzes) {
        this.playedQuizzes = playedQuizzes;
    }

    public List<MusicDTO> getBookmarkedSongs() {
        return bookmarkedSongs;
    }

    public void setBookmarkedSongs(List<MusicDTO> bookmarkedSongs) {
        this.bookmarkedSongs = bookmarkedSongs;
    }
}
