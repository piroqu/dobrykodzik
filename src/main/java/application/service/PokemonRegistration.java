package application.service;

import application.model.PokemonEntity;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

/**
 * Created by PiroACC on 2015-11-17.
 */
@Stateless

public class PokemonRegistration {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private Event<PokemonEntity> memberEventSrc;

    public void register(PokemonEntity pokemonEntity) throws Exception {
        log.info("Registering " + pokemonEntity.getName());
        em.persist(pokemonEntity);
        memberEventSrc.fire(pokemonEntity);
    }
}
