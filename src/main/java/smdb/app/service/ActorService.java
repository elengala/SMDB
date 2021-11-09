package smdb.app.service;

import smdb.app.domain.Actor;
import smdb.app.domain.Film;

public interface ActorService extends BaseService<Actor, Long> {
    Actor findByLastName(String lastname);
}
