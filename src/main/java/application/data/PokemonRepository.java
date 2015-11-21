package application.data;

import application.model.PokemonEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PiroACC on 2015-11-21.
 */
@ApplicationScoped
public class PokemonRepository {

    @Inject
    private EntityManager em;


    public List<PokemonEntity > testoweWyszukiwanie3() {
        List<PokemonEntity> test = new ArrayList();
        test.add(em.find(PokemonEntity.class, 1));
        test.add(em.find(PokemonEntity.class, 2));

        return  test;
    }
}
