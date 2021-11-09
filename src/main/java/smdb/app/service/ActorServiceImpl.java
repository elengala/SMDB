package smdb.app.service;

import smdb.app.domain.Actor;
import smdb.app.repository.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl extends AbstractService<Actor> implements ActorService {
    private final ActorRepository actorRepository;

    @Override
    public JpaRepository<Actor, Long> getRepository() {
        return actorRepository;
    }

    @Override
    public Actor findByLastName(final String lastname) {
        return actorRepository.findAll().stream().filter(c -> c.getlastname().equals(lastname)).findAny().orElse(null);
    }
}