package smdb.app.bootstrap;

import smdb.app.base.AbstractLogComponent;
import smdb.app.domain.Film;
import smdb.app.domain.Actor;
import smdb.app.service.FilmService;
import smdb.app.service.ActorService;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Profile("generate-content")
@RequiredArgsConstructor
public class GenerateContentRunner extends AbstractLogComponent implements CommandLineRunner {
    private final ActorService actorService;
    private final FilmService filmService;

    @Override
    public void run(String... args) {
        generateActors();
        generateFilms();
        logger.info("Runner finished");
    }

    private void generateActors() {
        //@formatter:off
        List<Actor> actors = actorService.createAll(
                Actor.builder().firstname("Keira").lastname("Knightley")
                        .age(37).build(),
                Actor.builder().firstname("Mathew").lastname("McFadyen")
                        .age(38).build(),
                Actor.builder().firstname("Jodie").lastname("Foster")
                        .age(49).build(),
                Actor.builder().firstname("Judy").lastname("Dench")
                        .age(60).build(),
                Actor.builder().firstname("Johny").lastname("Dep")
                        .age(55).build());
        //@formatter:on

        logger.info("{} actors created.", actors.size());

        // Get all actors
        actorService.findAll().forEach(c -> logger.info("{}", c));
        logger.info("AAA {}",actorService.findAll().toString());

    }

    private void generateFilms() {
        // Load customer and create an order by adding/updating/removing content before checking it out
        Film firstFilm = filmService.initiateFilm();
        firstFilm.setTitle("Pride And Prejudice");
        firstFilm.setYear("1995");
        filmService.addActor(firstFilm, actorService.findByLastName("Knightley"));
        filmService.addActor(firstFilm, actorService.findByLastName("McFadyen"));
        filmService.saveFilm(firstFilm);

        Film secondFilm = filmService.initiateFilm();
        secondFilm.setTitle("James Bond 200");
        secondFilm.setYear("1996");
        filmService.addActor(secondFilm, actorService.findByLastName("Dench"));
        filmService.saveFilm(secondFilm);

        Film thirdFilm = filmService.initiateFilm();
        thirdFilm.setTitle("The Gift");
        thirdFilm.setYear("1997");
        filmService.addActor(thirdFilm, actorService.findByLastName("Foster"));
        filmService.saveFilm(thirdFilm);

        Film fourthFilm = filmService.initiateFilm();
        fourthFilm.setTitle("Pirates of the Caribbean");
        fourthFilm.setYear("1999");
        filmService.addActor(fourthFilm, actorService.findByLastName("Knightley"));
        filmService.addActor(fourthFilm, actorService.findByLastName("Dep"));
        filmService.saveFilm(fourthFilm);

        Film fifthFilm = filmService.initiateFilm();
        fifthFilm.setTitle("Black Swan");
        fifthFilm.setYear("2000");
        filmService.addActor(fifthFilm, actorService.findByLastName("Knightley"));
        filmService.saveFilm(fifthFilm);


        logger.info("{} films created.", filmService.findAll().size());

        // Get all actors
        filmService.findAll().forEach(c -> logger.info("{}", c));
        logger.info("BBB {}",filmService.findAll().toString());
    }
}
