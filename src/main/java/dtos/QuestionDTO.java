package dtos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import entities.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionDTO {
    private int questionID;
    private String question;
    private String choice1;
    private String choice2;
    private String choice3;
    private String answer;
    private MusicDTO music;
    private List<String> allChoices = new ArrayList<>();

//    @JsonBackReference
//    private QuizDTO quiz;

    public QuestionDTO() {
        allChoices.add(choice1);
        allChoices.add(choice2);
        allChoices.add(choice3);
        allChoices.add(answer);
    }

    public QuestionDTO(Question question) {
        this.questionID = question.getQuestionID();
        this.question = question.getQuestion();
        this.choice1 = question.getChoice1();
        this.choice2 = question.getChoice2();
        this.choice3 = question.getChoice3();
        this.answer = question.getAnswer();
        this.music = new MusicDTO(question.getMusic());
//        this.quiz = new QuizDTO(question.getQuiz());
        allChoices.add(choice1);
        allChoices.add(choice2);
        allChoices.add(choice3);
        allChoices.add(answer);
    }


    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
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

//    public QuizDTO getQuiz() {
//        return quiz;
//    }
//
//    public void setQuiz(QuizDTO quiz) {
//        this.quiz = quiz;
//    }

    public List<String> getAllChoices() {
        return allChoices;
    }

    public void setAllChoices(List<String> allChoices) {
        this.allChoices = allChoices;
    }
}
