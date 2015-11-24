package application.rest;
import application.model.Dziecko;
import application.model.dtos.DzieckoDTO;
import application.service.DzieckoHome;

import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.validation.Validator;
import javax.ws.rs.core.MediaType;

/**
 * Created by PiroACC on 2015-11-24.
 */
// The Java class will be hosted at the URI path "/helloworld"
@Path("/helloworld")
public class DzieciResourcesRESTService {

    @Inject
    private Logger log;

    @Inject
    private Validator validator;

    @Inject
    private DzieckoHome dzieckoHome;

    public DzieciResourcesRESTService() {
    }

    @GET
    @Produces("text/plain")
    public String getClichedMessage() {
        return "Hello World";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/childrens")
    public DzieckoDTO getDziecko(){
        Dziecko dziecko =  dzieckoHome.findById(1);
        DzieckoDTO dzieckoDTO = new DzieckoDTO(dziecko);
        return dzieckoDTO;
    }

}
