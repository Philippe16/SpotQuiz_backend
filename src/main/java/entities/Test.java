package entities;

import dtos.QuizDTO;
import dtos.UserDTO;
import facades.QuizFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Test {


    public static void main(String[] args) {
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        QuizFacade quizFacade = QuizFacade.getQuizFacade(emf);

//        Role role = new Role("user");
//        User user = new User("TestUser1", "test1@gmail.com", "superSecret", role);
//
//        em.getTransaction().begin();
//            em.persist(role);
//            em.persist(user);
//        em.getTransaction().commit();

//        Quiz quiz = new Quiz("First quiz");
//        Music music = new Music("songID_123", "Girl Of My Dreams", "Juice WRLD",
//               "link_img", "link_song");
//
//        Question question1 = new Question("Who is singing this song?", "Juice WRLD", "Machine Gun Kelly",
//               "Blackbear", "will.i.am", "Juice WRLD", music, quiz);
//        Question question2 = new Question("Question2", "A", "B", "C", "D", "D", music, quiz);
//        Question question3 = new Question("Question3", "A", "B", "C", "D", "A", music, quiz);
//        Question question4 = new Question("Question4", "A", "B", "C", "D", "B", music, quiz);
//        Question question5 = new Question("Question5", "A", "B", "C", "D", "A", music, quiz);
//
//        quiz.addQuestion(question1);
//        quiz.addQuestion(question2);
//        quiz.addQuestion(question3);
//        quiz.addQuestion(question4);
//        quiz.addQuestion(question5);
//
//        try{
//            User user = em.find(User.class, 1);
//            UserDTO userDTO = new UserDTO(user);
//
//            QuizDTO quizDTO = new QuizDTO(quiz);
//
//            quizFacade.createQuiz(userDTO, quizDTO);
//
//        }finally{
//            em.close();
//        }
    }
}


