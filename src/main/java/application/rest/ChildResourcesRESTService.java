package application.rest;

import application.model.*;
import application.model.dtos.mobile.request.child.ConnectionMDTOResponse;
import application.model.dtos.mobile.request.child.PositionMDTORequest;
import application.model.dtos.mobile.response.child.PositionMDTOResponse;
import application.service.*;

import java.util.Set;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.validation.Validator;
import javax.ws.rs.core.MediaType;


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

    @POST
    @Path("/send/position/{childId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PositionMDTOResponse synchronize(@PathParam("childId") Integer childId, PositionMDTORequest request) {
        PositionMDTOResponse response = new PositionMDTOResponse();
        Child child = childHome.findById(childId);
        Position positionToInsert = new Position(child, request);
        positionHome.persist(positionToInsert);
        response.setStatus("synchronized");
        return response;
    }

    @POST
    @Path("/connect/{childId}/{parentEmail}")
    @Produces(MediaType.APPLICATION_JSON)
    public ConnectionMDTOResponse connectWithParent(@PathParam("childId") Integer childId, @PathParam("parentEmail") String parentEmail) {
        ConnectionMDTOResponse response = new ConnectionMDTOResponse();
        try {
            log.info("Child-Parent connect recieved childId : " + childId + " and parentId : ");
            Child child = childHome.findById(childId);
            log.info("Child-Parent connect found child:" + child);
            Parent parent = parentHome.findByEmail(parentEmail);
            log.info("Child-Parent connect found parent:" + parent);
            Set<Child> childs = parent.getChilds();
            childs.add(child);
            parent.setChilds(childs);
            parentHome.merge(parent);
            response.setStatus("ok");
        }catch (RuntimeException re) {
            log.info("get failed");
            response.setStatus("failed");
        }
        return response;
    }



 /* public Kolejka createTaskAskParentToConnection(Rodzic rodzic,Dziecko child) {
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


/*    @POST
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
    }*/
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


/*    @POST
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
    }*/
}
