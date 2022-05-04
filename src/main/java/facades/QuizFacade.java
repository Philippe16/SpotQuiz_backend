package facades;

import dtos.MusicDTO;
import dtos.QuestionDTO;
import dtos.QuizDTO;
import entities.Music;
import entities.Question;
import entities.Quiz;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

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

    public void createQuiz(QuizDTO quizDTO){
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            Quiz quiz = new Quiz(quizDTO.getName());
            em.persist(quiz);

            for (QuestionDTO questionDTO : quizDTO.getQuestions()) {
                MusicDTO musicDTO = questionDTO.getMusic();
                Music music = new Music(musicDTO.getSongID(), musicDTO.getTitle(), musicDTO.getArtist(),
                        musicDTO.getCoverImgLink(), musicDTO.getSongSnippetLink());

                em.persist(music);

                Question question = new Question(questionDTO.getQuestion(), questionDTO.getChoice1(), questionDTO.getChoice2(),
                        questionDTO.getChoice3(), questionDTO
                        .getChoice4(), questionDTO.getAnswer(), music, quiz);

                em.persist(question);
            }

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}

/*
    Pusher bare til min branch
    Burde være det. ah, tiden. Du skulle gøre klar kl 30 push :P Si
    Oooki, hvor var vi? xD

    Men vi skal i hvert fald ind i vores quiz og have fat i dets Question, som jo er en liste.
    Når vi har listen skal vi loope.

    Men først kan vi også starte med at hive MusicDTO ud af vores QuestionDTO, for den skal jo også
    laves til en entity og persistes.
    Si. Nu har du MusicDTO. Udfra den skal vi lave et Music obj. si
    Bare Music. Den skal nok importeres.
    Si. Og inde i dets parentes skal vi have data, som vi får fra vores MusicDto

    For hvert question (husk det er en dto), så skal vi lave det om til en entity (altså ikke dto)
    og derefter persiste.


    Oki, så hvordan laver en bruger en quiz?
    Hele den funktionalitet skal vi have cuttet ned til små bidder.
    Så vi skal forestille os at når brugeren klikker på "Create quiz" knappen,
    så kommer de ind til en side, hvor de kan søge på en sang og derefter skrive spørgsmål og svar.
    Når de er færdige klikker de "Save" og der bliver sendt en POST request til vores server.
    Altså skal vi have et endpoin klar.
    Tænker at vi tager det i et. Så de skriver alt data også sender de en request, som indeholder hele quizzen
    med spørgsmål.

    Når vi så her på serveren modtager den request, så laver vi det fra json om til obj.
    Fx Quiz obj. som indeholder Question obj.'er og et Music obj.

    Når det er lavet skal vi vel egentlig "bare" persiste dem ind i db, ligesom vi gjorde foroven i vores test.
    På den måde vil quizzen blive gemt på db.
    Ved ikke om jeg har tænkt det hele igennem, men lige umiddelbart er det det vigtigste.

*/