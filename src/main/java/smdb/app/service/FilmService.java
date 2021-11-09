package smdb.app.service;

import smdb.app.domain.Film;
import smdb.app.domain.Actor;

public interface FilmService extends BaseService<Film, Long> {

    Film initiateFilm();
    void addActor(Film film, Actor actor);

    Film findByTitle(String title);
}
