package facades;

import dtos.*;
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

    public boolean createQuiz(NewQuizDTO newQuizDTO){
        EntityManager em = getEntityManager();

        try {
            // Find the user who created the quiz
            User user = em.find(User.class, newQuizDTO.getUserID());

            // Make DTO's to entities
            Quiz quiz = new Quiz(newQuizDTO.getQuizTitle());
            ArrayList<Music> musicUsedInQuiz = new ArrayList<>();

            for (NewQuestionDTO newQuestionDTO : newQuizDTO.getQuestions()) {
                MusicDTO musicDTO = newQuestionDTO.getMusic();
                Music music = new Music(musicDTO.getSongID(), musicDTO.getTitle(), musicDTO.getArtist(),
                       musicDTO.getCoverImgLink(), musicDTO.getSongSnippetLink());

                if(musicUsedInQuiz.size() > 0){
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

                Question question = new Question(newQuestionDTO.getQuestion(), newQuestionDTO.getChoice1(), newQuestionDTO.getChoice2(),
                       newQuestionDTO.getChoice3(), newQuestionDTO.getAnswer(), music);

                quiz.addQuestion(question);
            }

            // Add the new quiz to the user's list of created quizzes
            user.addQuizToCreatedQuizzes(quiz);

            em.getTransaction().begin();
                em.merge(user);
                em.persist(quiz);

                for(Music music : musicUsedInQuiz){
                    Music musicFromDB = em.find(Music.class, music.getSongID());

                    if(musicFromDB == null){
                        em.persist(music);
                    }
                }

                for(Question question : quiz.getQuestions()){
                    em.persist(question);
                }

            em.getTransaction().commit();
            return true;
        }catch(NullPointerException ex){
            return false;
        } finally {
            em.close();
        }
    }
}