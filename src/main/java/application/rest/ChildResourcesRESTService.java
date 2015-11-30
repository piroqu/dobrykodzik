package application.rest;

import application.helper.DateParser;
import application.model.*;
import application.model.dtos.mobile.request.DzieckoMDTORequest;
import application.model.dtos.mobile.request.PozycjaMDTO;
import application.model.dtos.mobile.response.DzieckoMDTOResponse;
import application.service.*;

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
public class ChildResourcesRESTService {

    @Inject
    private Logger log;

    @Inject
    private Validator validator;

    @Inject
    private ChildHome childHome;

    @Inject
    private PositionHome positionHome;

    @Inject
    private ParentHome parentHome;


    @Inject
    private Task taskHome;

    @Inject
    private Queue queueHome;

    public ChildResourcesRESTService() {
    }

    @GET
    @Produces("text/plain")
    public String getClichedMessage() {
        return "Hello World";
    }

/*    @POST
    @Path("/connect/{parentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void connectWithParent(DzieckoMDTORequest dzieckoMDTORequest,
                                  @PathParam("parentId") Integer parentId) {
        Integer childId = dzieckoMDTORequest.getDzieckoId();
        log.info("Child-Parent connect recieved childId : " + childId + " and parentId : ");
        Child currentChild = childHome.findById(childId);
        log.info("Child-Parent connect found child:" + currentChild);
        Parent targetParent = parentHome.findById(parentId);
        log.info("Child-Parent connect found parent:" + targetParent);
        Queue taskQueue = createTaskAskParentToConnection(targetParent,currentChild);
        queueHome.persist(taskQueue);
        log.info("Child connect with parent task added : " +taskQueue);
    }*/

  /*  public Kolejka createTaskAskParentToConnection(Rodzic rodzic,Dziecko child) {
        Kolejka taskQueue = new Kolejka();
        Integer dodajDzieckoTaskId = 1;
        TypZadanie typZadanie = taskHome.findById(dodajDzieckoTaskId);
        taskQueue.setTypZadanie(typZadanie);
        taskQueue.setStatus(true);
        taskQueue.setData(DateParser.getCurrentParsedDate());
        taskQueue.setRodzic(rodzic);
        taskQueue.setDziecko(child);
        return taskQueue;
    }*/

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public DzieckoMDTOResponse register(DzieckoMDTORequest dzieckoMDTORequest) {
        log.info("SERVER RECIEVED : " + dzieckoMDTORequest);
        Child child = new Child(dzieckoMDTORequest);
        Integer generatedID = childHome.persistAndGetId(child);
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
    @Path("/synchronize/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<PozycjaMDTO> synchronize(List<PozycjaMDTO> positionsToSync) {
        Integer childId = positionsToSync.get(0).getFkDzieckoId();
        Child currentChild = childHome.findById(childId);
        for (PozycjaMDTO tempPozycjaMDTO : positionsToSync) {
            log.info("Try to insert : " + tempPozycjaMDTO);
            Position tempPozycja = new Position(tempPozycjaMDTO, currentChild);
            positionHome.persist(tempPozycja);
            log.info("Inserted : " + tempPozycjaMDTO + " OK !");
            tempPozycjaMDTO.setCzyZsynchronizowano(true);
        }
        return positionsToSync;
    }
}