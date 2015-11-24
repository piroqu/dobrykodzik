package application.rest;

import application.model.Rodzic;
import application.model.dtos.mobile.RodzicDTO;
import application.service.KolejkaHome;
import application.service.RodzicHome;

import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.logging.Logger;

/**
 * Created by PiroACC on 2015-11-24.
 */
@Path("/parent")
public class RodzicResourcesRESTService {
    @Inject
    private Logger log;

    @Inject
    private Validator validator;

    @Inject
    private RodzicHome rodzicHome;

    @Inject
    private KolejkaHome kolejkaHome;

    @GET
    @Produces("text/plain")
    public String getClichedMessage() {
        return "Hello World";
    }

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("text/plain")
    public String register(RodzicDTO rodzicDTO){
        Rodzic rodzic = new Rodzic(rodzicDTO);
        try {
            rodzicHome.persist(rodzic);
        } catch (RuntimeException ex){
            return "Dodawanie niemozliwe";
        }
        return "Dodano!";
    }
}
