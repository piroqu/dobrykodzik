package application.rest;

import application.model.*;
import application.model.dtos.mobile.request.DzieckoMDTO;
import application.model.dtos.mobile.request.PozycjaMDTO;
import application.model.dtos.mobile.response.DzieckoMDTOResponse;
import application.service.DzieckoHome;
import application.service.PozycjaHome;
import application.service.RodzicDzieckoHome;
import application.service.RodzicHome;

import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.validation.Validator;
import javax.ws.rs.core.MediaType;

/**
 * Created by PiroACC on 2015-11-24.
 */
// The Java class will be hosted at the URI path "/helloworld"
@Path("/child")
public class DzieckoResourcesRESTService {

    @Inject
    private Logger log;

    @Inject
    private Validator validator;

    @Inject
    private DzieckoHome dzieckoHome;

    @Inject
    private PozycjaHome pozycjaHome;

    @Inject
    private RodzicHome rodzicHome;

    @Inject
    private RodzicDzieckoHome rodzicDzieckoHome;

    public DzieckoResourcesRESTService() {
    }

    @GET
    @Produces("text/plain")
    public String getClichedMessage() {
        return "Hello World";
    }

    @POST
    @Path("/connect")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void connect(DzieckoMDTO dzieckoMDTO) {
        Integer childId = dzieckoMDTO.getDzieckoId();
        Integer parentId = 7;
        log.info("Child-Parent connect recieved childId : " + childId + " and parentId : ");
        Dziecko currentChild = dzieckoHome.findById(childId);
        log.info("Child-Parent connect found child:" +currentChild);
        Rodzic targetParent = rodzicHome.findById(parentId);
        log.info("Child-Parent connect found parent:" +targetParent);
        RodzicDziecko rodzicDziecko = new RodzicDziecko();
        RodzicDzieckoId rodzicDzieckoId = new RodzicDzieckoId();
        rodzicDzieckoId.setDzieckodzieckoId(childId);
        rodzicDzieckoId.setRodzicrodzicId(parentId);
        rodzicDziecko.setDziecko(currentChild);
        rodzicDziecko.setRodzic(targetParent);
        rodzicDziecko.setId(rodzicDzieckoId);
        rodzicDzieckoHome.persist(rodzicDziecko);
        log.info("Child-Parent persist : " +rodzicDziecko);
    }

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public DzieckoMDTOResponse register(DzieckoMDTO dzieckoMDTO) {
        log.info("SERVER RECIEVED : " + dzieckoMDTO);
        Dziecko dziecko = new Dziecko(dzieckoMDTO);
        Integer generatedID = dzieckoHome.persistAndGetId(dziecko);
        log.info("ID DZIECKO: " + String.valueOf(generatedID));
        DzieckoMDTOResponse dzieckoMDTOResponse = new DzieckoMDTOResponse();
        dzieckoMDTOResponse.setDzieckoId(generatedID);
        return dzieckoMDTOResponse;
    }
/*    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(DzieckoMDTO dzieckoMDTO){
        Response.ResponseBuilder builder = null;
        Dziecko dziecko = new Dziecko(dzieckoMDTO);
        try {
            Integer generatedID = dzieckoHome.persistAndGetId(dziecko);
            log.info("ID DZIECKO: " +String.valueOf(generatedID));
            Map<String, String> responseObj = new HashMap<String, String>();
            responseObj.put("id", String.valueOf(generatedID));
            builder = Response.status(Response.Status.OK).entity(responseObj);
        } catch (RuntimeException ex){
            Map<String, String> responseObj = new HashMap<String, String>();
            responseObj.put("error", ex.getMessage());
            builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
        }
        return builder.build();
    }*/

    @POST
    @Path("/synchronize/{chilId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<PozycjaMDTO> synchronize(@PathParam("chilId") Integer childId,
                                         List<PozycjaMDTO> positionsToSync) {
        Dziecko currentChild = dzieckoHome.findById(childId);
        for (PozycjaMDTO tempPozycjaMDTO : positionsToSync) {
            log.info("Inster " + tempPozycjaMDTO);
            Pozycja tempPozycja = new Pozycja(tempPozycjaMDTO, currentChild);
            pozycjaHome.persist(tempPozycja);
            log.info("Inster " + tempPozycjaMDTO + " OK !");
            tempPozycjaMDTO.setCzyZsynchronizowano(true);
        }
        return positionsToSync;
    }
}
