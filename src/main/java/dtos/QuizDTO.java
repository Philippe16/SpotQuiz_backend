package dtos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import entities.Question;
import entities.Quiz;

import java.util.ArrayList;
import java.util.List;

public class QuizDTO {
    private int quizID;
    private String name;
    @JsonManagedReference
    private List<QuestionDTO> questions = new ArrayList<>();

    public QuizDTO() {
    }

    public QuizDTO(Quiz quiz) {
        this.quizID = quiz.getQuizID();
        this.name = quiz.getName();

        for(Question question : quiz.getQuestions()){
            questions.add(new QuestionDTO(question));
        }
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

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }
}
