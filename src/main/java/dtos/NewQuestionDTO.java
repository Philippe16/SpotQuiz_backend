package dtos;

public class NewQuestionDTO {
   private String question;
   private String choice1;
   private String choice2;
   private String choice3;
   private String answer;
   private MusicDTO music;

   public NewQuestionDTO(String question, String choice1, String choice2, String choice3, String answer, MusicDTO music) {
      this.question = question;
      this.choice1 = choice1;
      this.choice2 = choice2;
      this.choice3 = choice3;
      this.answer = answer;
      this.music = music;
   }

   public String getQuestion() {
      return question;
   }

   public void setQuestion(String question) {
      this.question = question;
   }

   public String getChoice1() {
      return choice1;
   }

   public void setChoice1(String choice1) {
      this.choice1 = choice1;
   }

   public String getChoice2() {
      return choice2;
   }

   public void setChoice2(String choice2) {
      this.choice2 = choice2;
   }

   public String getChoice3() {
      return choice3;
   }

   public void setChoice3(String choice3) {
      this.choice3 = choice3;
   }

   public String getAnswer() {
      return answer;
   }

   public void setAnswer(String answer) {
      this.answer = answer;
   }

   public MusicDTO getMusic() {
      return music;
   }

   public void setMusic(MusicDTO music) {
      this.music = music;
   }
}
