package dtos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import entities.Role;

import java.util.ArrayList;
import java.util.List;

public class NewUserDTO {
   private String username;
   private String email;
   private String password;
   @JsonBackReference
   private Role role;
   private List<QuizDTO> createdQuizzes = new ArrayList<>();
   private List<QuizDTO> playedQuizzes = new ArrayList<>();
   private List<MusicDTO> bookmarkedSongs = new ArrayList<>();

   public NewUserDTO(String username, String email, String password) {
      this.username = username;
      this.email = email;
      this.password = password;
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
