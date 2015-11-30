package application.rest;

import application.model.*;
import application.model.dtos.mobile.request.RodzicMDTORequest;
import application.model.dtos.mobile.response.KolejkaRodzicMDTOResponse;
import application.model.dtos.mobile.response.PozycjaMDTOResponse;
import application.model.dtos.mobile.response.RodzicMDTOResponse;
import application.service.DzieckoHome;
import application.service.KolejkaHome;
import application.service.PozycjaHome;
import application.service.RodzicHome;
import application.util.Serializer;

import javax.inject.Inject;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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

    @Inject
    private PozycjaHome pozycjaHome;

    @Inject
    private DzieckoHome dzieckoHome;

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

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RodzicMDTOResponse register(RodzicMDTORequest rodzicMDTORequest) {
        log.info("Parent register recievied: " + rodzicMDTORequest);
        Rodzic rodzic = new Rodzic(rodzicMDTORequest);
        RodzicMDTOResponse rodzicMDTOResponse = new RodzicMDTOResponse();   //TODO add QUEUE !!
//       Kolejka task = createRegisterQueue(rodzicMDTO);
//        kolejkaHome.persist(task);
        Integer rodzicId = rodzicHome.persistAndGetId(rodzic);
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
        List<Pozycja> positions = pozycjaHome.findByChilId(dziecko);
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
        Rodzic currentRodzic = rodzicHome.findById(parentId);
        List<Kolejka> parentsConnectionRequests = kolejkaHome.findByParentAndWithStatusActivte(currentRodzic);
        List<KolejkaRodzicMDTOResponse> reponse = new ArrayList<>();
        for (Kolejka tmp : parentsConnectionRequests) {
            KolejkaRodzicMDTOResponse tempResponse = new KolejkaRodzicMDTOResponse(tmp);
            reponse.add(tempResponse);
            tmp.setStatus(false);
            kolejkaHome.merge(tmp);
        }
        return reponse;
    }
}
