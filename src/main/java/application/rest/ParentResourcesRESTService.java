package application.rest;

import application.model.Parent;
import application.model.dtos.mobile.request.RodzicMDTORequest;
import application.model.dtos.mobile.response.KolejkaRodzicMDTOResponse;
import application.model.dtos.mobile.response.PozycjaMDTOResponse;
import application.model.dtos.mobile.response.RodzicMDTOResponse;
import application.service.ChildHome;
import application.service.DzieckoHome;
import application.service.KolejkaHome;
import application.service.ParentHome;
import application.service.PositionHome;
import application.service.PozycjaHome;
import application.service.QueueHome;
import application.service.RodzicHome;

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
    @Path("/login/{parentEmail}/{parentPassword}")
    @Produces(MediaType.APPLICATION_JSON)
    public RodzicMDTORequest getParentData(@PathParam("parentEmail") String parentEmail, @PathParam("parentPassword") String parentPassword){
        Parent parent = null;
        RodzicMDTORequest rodzicMDTOResponse=null;
        try {
            parent  = parentHome.findByEmail(parentEmail);
        }catch (RuntimeException re) {
            log.info("PARENT NOT FOUND");
        }
        if(parent.getHaslo().equals(parentPassword)) {
            rodzicMDTOResponse = new RodzicMDTORequest(parent);
            return rodzicMDTOResponse;
        }else{
            log.info("INCORRECT PASSWORD");
        }
        return rodzicMDTOResponse;
    }

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RodzicMDTOResponse register(RodzicMDTORequest rodzicMDTORequest) {
        log.info("Parent register recievied: " + rodzicMDTORequest);
        Rodzic rodzic = new Rodzic(rodzicMDTORequest);
        RodzicMDTOResponse rodzicMDTOResponse = new RodzicMDTOResponse();   //TODO add QUEUE !!
//       Kolejka task = createRegisterQueue(rodzicMDTO);
//        queueHome.persist(task);
        Integer rodzicId = parentHome.persistAndGetId(rodzic);
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
    }
}