package entities;

import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Test {


    public static void main(String[] args) {
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        Role role = new Role("user");
        User user = new User("TestUser2", "test2@gmail.com", "superSecret", role);
        Quiz quiz = new Quiz("Quiz1");
        Music music = new Music("SongID", "Title", "Artist", "CoverImgLink", "Snippet link");

        Question question1 = new Question("Question1", "A", "B", "C", "D", "C", music, quiz);
        Question question2 = new Question("Question2", "A", "B", "C", "D", "D", music, quiz);
        Question question3 = new Question("Question3", "A", "B", "C", "D", "A", music, quiz);
        Question question4 = new Question("Question4", "A", "B", "C", "D", "B", music, quiz);
        Question question5 = new Question("Question5", "A", "B", "C", "D", "A", music, quiz);

        user.createQuiz(quiz);

        em.getTransaction().begin();
            em.persist(role);
            em.persist(user);
            em.persist(quiz);
            em.persist(music);
            em.persist(question1);
            em.persist(question2);
            em.persist(question3);
            em.persist(question4);
            em.persist(question5);
        em.getTransaction().commit();
    }
}


