package facades;

import dtos.MusicDTO;
import dtos.QuestionDTO;
import dtos.QuizDTO;
import dtos.UserDTO;
import entities.Music;
import entities.Question;
import entities.Quiz;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;

public class QuizFacade {
    private static EntityManagerFactory emf;
    private static QuizFacade instance;

    private QuizFacade() {
    }

    public static QuizFacade getQuizFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new QuizFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void createQuiz(UserDTO userDTO, QuizDTO quizDTO){
        EntityManager em = getEntityManager();

        try {
            // Find the user who created the quiz
            User user = em.find(User.class, userDTO.getUserID());

            // Make DTO's to entities
            Quiz quiz = new Quiz(quizDTO.getName());
            ArrayList<Music> musicUsedInQuiz = new ArrayList<>();
            ArrayList<Question> questionsUsedInQuiz = new ArrayList<>();

            for (QuestionDTO questionDTO : quizDTO.getQuestions()) {
                MusicDTO musicDTO = questionDTO.getMusic();
                Music music = new Music(musicDTO.getSongID(), musicDTO.getTitle(), musicDTO.getArtist(),
                       musicDTO.getCoverImgLink(), musicDTO.getSongSnippetLink());

                if(questionsUsedInQuiz.size() > 0){
                    boolean alreadyInList = false;

                    for(Music musicFromList : musicUsedInQuiz){
                        if(music.getSongID().equals(musicFromList.getSongID())){
                           alreadyInList = true;
                           break;
                        }
                    }

                    if(!alreadyInList){
                        musicUsedInQuiz.add(music);
                    }
                }else{
                    musicUsedInQuiz.add(music);
                }

                Question question = new Question(questionDTO.getQuestion(), questionDTO.getChoice1(), questionDTO.getChoice2(),
                       questionDTO.getChoice3(), questionDTO
                       .getChoice4(), questionDTO.getAnswer(), music, quiz);

                quiz.addQuestion(question);
                questionsUsedInQuiz.add(question);
            }

            // Add the new quiz to the user's list of created quizzes
            user.addQuizToCreatedQuizzes(quiz);

            em.getTransaction().begin();
//                Quiz quiz = new Quiz(quizDTO.getName());
                em.merge(user);
                em.persist(quiz);

                for(Music music : musicUsedInQuiz){
                    Music musicFromDB = em.find(Music.class, music.getSongID());

                    if(musicFromDB == null){
                        em.persist(music);
                    }
                }

                for(Question question : questionsUsedInQuiz){
                    em.persist(question);
                }

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}