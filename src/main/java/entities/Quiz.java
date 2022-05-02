package entities;

import java.util.ArrayList;
import java.util.List;

public class Quiz {

    private String name;
    private List<Question> questions = new ArrayList<>();


    public Quiz() {
    }

    public Quiz(String name, List<Question> questions) {
        this.name = name;
        this.questions = questions;
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
