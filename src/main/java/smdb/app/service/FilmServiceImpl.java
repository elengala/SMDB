package smdb.app.service;


import smdb.app.domain.Film;
import smdb.app.domain.Actor;
import smdb.app.repository.FilmRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl extends AbstractService<Film> implements FilmService {
    private final FilmRepository filmRepository;

    @Override
    public JpaRepository<Film, Long> getRepository() {
        return filmRepository;
    }

    @Override
    public Film initiateFilm() {
        return Film.builder().build();
    }

    @Override
    public void addActor(Film film, Actor actor) {
        film.getActors().add(actor);
    }

    @Override
    public Film findByTitle(final String title) {
        return filmRepository.findAll().stream().filter(c -> c.getTitle().equals(title)).findAny().orElse(null);
    }

    @Override
    public Film saveFilm(Film film) {
        return create(film);
    }
}