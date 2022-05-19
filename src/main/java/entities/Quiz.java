package entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "quizzes")
public class Quiz{

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quiz_id", nullable = false, unique = true)
    private int quizID;

    @Basic(optional = false)
    @Column(name = "title", nullable = false)
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_created", nullable = false)
    private LocalDate dateCreated;

    @OneToMany(mappedBy="quiz")
    private List<Question> questions = new ArrayList<>();

    public Quiz() {
    }

    public Quiz(String name){
        this.name = name;
        this.dateCreated = LocalDate.now();
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
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

    public void addQuestion(Question question){
        questions.add(question);

        question.setQuiz(this);
    }

}
