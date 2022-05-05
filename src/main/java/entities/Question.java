package entities;

import javax.persistence.*;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id", nullable = false, unique = true)
    private int questionID;

    @Basic(optional = false)
    @Column(name = "question", nullable = false)
    private String question;

    @Basic(optional = false)
    @Column(name = "choice1", nullable = false)
    private String choice1;

    @Basic(optional = false)
    @Column(name = "choice2", nullable = false)
    private String choice2;

    @Basic(optional = false)
    @Column(name = "choice3", nullable = false)
    private String choice3;

    @Basic(optional = false)
    @Column(name = "choice4", nullable = false)
    private String choice4;

    @Basic(optional = false)
    @Column(name = "correct_answer", nullable = false)
    private String answer;

    @JoinColumn(name = "fk_music_id", nullable = false)
    @ManyToOne(fetch=FetchType.LAZY)
    private Music music;

    @ManyToOne
    @JoinColumn(name="fk_quiz_id", nullable = false)
    private Quiz quiz;

    public Question() {
    }

    public Question(String question, String choice1, String choice2, String choice3, String choice4,
                    String answer, Music music) {
        this.question = question;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;
        this.answer = answer;
        this.music = music;
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

    public String getChoice4() {
        return choice4;
    }

    public void setChoice4(String choice4) {
        this.choice4 = choice4;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

}
