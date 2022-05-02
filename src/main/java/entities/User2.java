package entities;

import java.util.ArrayList;
import java.util.List;

public class User2 {
    private String userID;
    private String username;
    private String email;
    private String password;
    private List<Quiz> quizzes = new ArrayList<>();
    private List<BookmarkedSong> bookmarkedSongs = new ArrayList<>();

    public User2() {
    }

    public User2(String userID, String username, String email, String password, List<Quiz> quizzes, List<BookmarkedSong> bookmarkedSongs) {
        this.userID = userID;
        this.username = username;
        this.email = email;
        this.password = password;
        this.quizzes = quizzes;
        this.bookmarkedSongs = bookmarkedSongs;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
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

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    public List<BookmarkedSong> getBookmarkedSongs() {
        return bookmarkedSongs;
    }

    public void setBookmarkedSongs(List<BookmarkedSong> bookmarkedSongs) {
        this.bookmarkedSongs = bookmarkedSongs;
    }
}

/*
    Goodie. Ser lige de andre igennem :D
*/