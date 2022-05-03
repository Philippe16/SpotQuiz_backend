package dtos;

import entities.Question;
import entities.Quiz;

import java.util.ArrayList;
import java.util.List;


public class QuizDTO {

    private int quizID;
    private String name;
    private List<Question> questions = new ArrayList<>();


    public QuizDTO() {
    }

    public QuizDTO(Quiz quiz) {
        this.quizID = quiz.getQuizID();
        this.name = quiz.getName();
        this.questions = quiz.getQuestions();
    }

    public int getQuizID() {
        return quizID;
    }

    public void setQuizID(int quizID) {
        this.quizID = quizID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
