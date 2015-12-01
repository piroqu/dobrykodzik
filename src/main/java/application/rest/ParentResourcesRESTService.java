package application.rest;

import application.model.Child;
import application.model.Parent;
import application.model.Position;
import application.model.dtos.mobile.response.parent.ParentChildMDTOResponse;
import application.model.dtos.mobile.response.parent.PositionForParentMDTOResponse;
import application.service.ChildHome;
import application.service.ParentHome;
import application.service.PositionHome;
import application.service.QueueHome;

import javax.inject.Inject;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;
import java.util.logging.Logger;

@Path("/parent")
public class ParentResourcesRESTService {
    @Inject
    private Logger log;

    @Inject
    private Validator validator;

    @Inject
    private ParentHome parentHome;

    @Inject
    private QueueHome queueHome;

    @Inject
    private PositionHome positionHome;

    @Inject
    private ChildHome childHome;

    @GET
    @Produces("text/plain")
    public String getClichedMessage() {
        return "Hello World";
    }

    @POST
    @Path("/test")
    @Consumes("text/plain")
    @Produces(MediaType.APPLICATION_JSON)
    public String test(String param) {
        return "Brawa " + param;
    }

    @GET
    @Path("/childrens/{parentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ParentChildMDTOResponse> getChildrens(@PathParam("parentId") Integer parentId){
        Parent parent = parentHome.findByIdAndGetChildrens(parentId);
        List<ParentChildMDTOResponse> parentChildrens = new ArrayList<>() ;
        for(Child tempChild : parent.getChilds()){
            ParentChildMDTOResponse tempParentChildren = new ParentChildMDTOResponse(tempChild);
            parentChildrens.add(tempParentChildren);
        }
        return parentChildrens;
    }

    @GET
    @Path("/position/{childrenId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PositionForParentMDTOResponse> getChildrenPositions(@PathParam("childrenId") Integer childrenId){
        Child child = childHome.findByIdAndInitializePositions(childrenId);
        List<PositionForParentMDTOResponse> response=new ArrayList<>() ;
        for(Position tempPosition :child.getPositions()){
            PositionForParentMDTOResponse tempResponseObj = new PositionForParentMDTOResponse(tempPosition);
            response.add(tempResponseObj);
        }
        return response;
    }
/*
    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RodzicMDTOResponse register(RodzicMDTORequest rodzicMDTORequest) {
        log.info("Parent register recievied: " + rodzicMDTORequest);
        Parent parent = new Parent(rodzicMDTORequest);
        RodzicMDTOResponse rodzicMDTOResponse = new RodzicMDTOResponse();   //TODO add QUEUE !!
//       Kolejka task = createRegisterQueue(rodzicMDTO);
//        queueHome.persist(task);
        Integer rodzicId = parentHome.persistAndGetId(parent);
        rodzicMDTOResponse.setParentId(rodzicId);
        log.info("Parent register sends: " + rodzicMDTOResponse);
        return rodzicMDTOResponse;
    }

    @POST
    @Path("/position/{childId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PozycjaMDTOResponse> getChildsPositions(@PathParam("childId") Integer childId) {
        List<PozycjaMDTOResponse> response = new ArrayList<>();
        log.info("Parent get child positons for childId : " + childId);
        Dziecko dziecko = dzieckoHome.findById(childId);
        List<Pozycja> positions = positionHome.findByChilId(dziecko);
        for (Pozycja tmp : positions) {
            PozycjaMDTOResponse pozycjaMDTOResponse = new PozycjaMDTOResponse();
            pozycjaMDTOResponse.setCzas(tmp.getCzas());
            pozycjaMDTOResponse.setDlugoscGeograficzna(tmp.getDlugoscGeograficzna());
            pozycjaMDTOResponse.setSzerokoscGeograficzna(tmp.getSzerokoscGeograficzna());
            pozycjaMDTOResponse.setPozycjaId(tmp.getPozycjaId());
            response.add(pozycjaMDTOResponse);
            log.info("Found positions for childId: " + childId + pozycjaMDTOResponse);
        }
        return response;
    }

    @POST
    @Path("/queue/check")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<KolejkaRodzicMDTOResponse> getConnectionRequests(RodzicMDTORequest rodzicMDTORequest) {
        Integer parentId = rodzicMDTORequest.getRodzicId();
        Rodzic currentRodzic = parentHome.findById(parentId);
        List<Kolejka> parentsConnectionRequests = queueHome.findByParentAndWithStatusActivte(currentRodzic);
        List<KolejkaRodzicMDTOResponse> reponse = new ArrayList<>();
        for (Kolejka tmp : parentsConnectionRequests) {
            KolejkaRodzicMDTOResponse tempResponse = new KolejkaRodzicMDTOResponse(tmp);
            reponse.add(tempResponse);
            tmp.setStatus(false);
            queueHome.merge(tmp);
        }
        return reponse;
    }*/
}
