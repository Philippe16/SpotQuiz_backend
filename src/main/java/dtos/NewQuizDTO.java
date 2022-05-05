package dtos;

import java.util.ArrayList;
import java.util.List;

public class NewQuizDTO {
   private int userID;
   private String quizTitle;
   private List<NewQuestionDTO> questions = new ArrayList<>();

   public NewQuizDTO(int userID, String quizTitle, List<NewQuestionDTO> questions) {
      this.userID = userID;
      this.quizTitle = quizTitle;
      this.questions = questions;
   }

   public int getUserID() {
      return userID;
   }

   public void setUserID(int userID) {
      this.userID = userID;
   }

   public String getQuizTitle() {
      return quizTitle;
   }

   public void setQuizTitle(String quizTitle) {
      this.quizTitle = quizTitle;
   }

   public List<NewQuestionDTO> getQuestions() {
      return questions;
   }

   public void setQuestions(List<NewQuestionDTO> questions) {
      this.questions = questions;
   }
}
