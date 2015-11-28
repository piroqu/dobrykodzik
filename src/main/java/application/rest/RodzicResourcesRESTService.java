package application.rest;

import application.model.Kolejka;
import application.model.Rodzic;
import application.model.dtos.mobile.RodzicMDTO;
import application.service.KolejkaHome;
import application.service.RodzicHome;
import application.util.Serializer;

import javax.inject.Inject;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
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
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(RodzicMDTO rodzicMDTO){
        Response.ResponseBuilder builder = null;
        Rodzic rodzic = new Rodzic(rodzicMDTO);
 //       Kolejka task = createRegisterQueue(rodzicMDTO);
//        kolejkaHome.persist(task);
        try {
            rodzicHome.persist(rodzic);
            builder= Response.ok();
        } catch (RuntimeException ex){
            Map<String, String> responseObj = new HashMap<String, String>();
            responseObj.put("error", ex.getMessage());
            builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
        }
        return builder.build();
    }

    public Kolejka createRegisterQueue(RodzicMDTO rodzicMDTO){
        Kolejka registerQueue = new Kolejka();
        registerQueue.setStatus(true);
        registerQueue.setData(Calendar.getInstance().getTime());
        registerQueue.setPriorytet(0);
        byte[] rodzicAsBytes = new byte[0];
        try {
            rodzicAsBytes = Serializer.serialize(rodzicMDTO);
        } catch (IOException e) {
            log.info("Unable to serialize rodzicMDTO " + rodzicMDTO.toString());
            e.printStackTrace();
        }
        registerQueue.setDane(rodzicAsBytes);
        return registerQueue;
    }
}
