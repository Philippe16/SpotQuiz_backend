package entities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.*;
import facades.QuizFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;

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

//        Music music = new Music("songID_1234", "Bois Lie", "Avril Lavigne",
//               "link_img", "link_song");
//        MusicDTO musicDTO = new MusicDTO(music);
//
//        ArrayList<NewQuestionDTO> questions = new ArrayList<>();
//
//        NewQuestionDTO question1 = new NewQuestionDTO("Who is singing this song?", "Hayley Williams",
//               "Avril Lavigne", "Taylor Swift", "Gayle", "Avril Lavigne", musicDTO);
//        questions.add(question1);
//
//        NewQuestionDTO question2 = new NewQuestionDTO("Question2", "A", "B", "C",
//               "D", "D", musicDTO);
//        questions.add(question2);
//
//        NewQuestionDTO question3 = new NewQuestionDTO("Question3", "A", "B", "C",
//               "D", "A", musicDTO);
//        questions.add(question3);
//
//        NewQuestionDTO question4 = new NewQuestionDTO("Question4", "A", "B", "C",
//               "D", "B", musicDTO);
//        questions.add(question4);
//
//        NewQuestionDTO question5 = new NewQuestionDTO("Question5", "A", "B", "C",
//               "D", "A", musicDTO);
//        questions.add(question5);
//
//
//        NewQuizDTO newQuizDTO = new NewQuizDTO(1, "Second quiz", questions);
//        quizFacade.createQuiz(newQuizDTO);
    }
}


