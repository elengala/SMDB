package smdb.app.service;

import smdb.app.domain.Actor;

public interface ActorService extends BaseService<Actor, Long> {
    Actor findByLastName(String lastname);
}
