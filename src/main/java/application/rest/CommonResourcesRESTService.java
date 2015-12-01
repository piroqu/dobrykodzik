package application.rest;

import application.helper.DateParser;
import application.model.Child;
import application.model.Parent;
import application.model.dtos.mobile.response.UserDataResponse;
import application.service.ChildHome;
import application.service.ParentHome;
import application.service.PositionHome;
import application.service.QueueHome;

import javax.inject.Inject;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

/**
 * Created by PiroACC on 2015-11-30.
 */
@Path("/common")
public class CommonResourcesRESTService {
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

    @POST
    @Path("/register/{userEmail}/{userPassword}/{name}/{phoneNumber}/{role}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response registration(@PathParam("userEmail") String userEmail, @PathParam("userPassword") String userPassword,
    @PathParam("name") String name,@PathParam("phoneNumber") String phoneNumber, @PathParam("role") String role){
        role=role.toLowerCase();
        Response.ResponseBuilder builder = null;
        if(role.equals("parent")){
            Parent parent = new Parent();
            parent.setEmail(userEmail);
            parent.setPassword(userPassword);
            parent.setName(name);
            parent.setPhoneNumber(phoneNumber);
            parent.setStatus(true);
            parent.setCreationDate(DateParser.getCurrentParsedDate());
            parentHome.persist(parent);
            builder = Response.ok();
        }else if(role.equals("child")){
            Child child = new Child();
            child.setEmail(userEmail);
            child.setPassword(userPassword);
            child.setName(name);
            child.setPhoneNumber(phoneNumber);
            child.setStatus(true);
            child.setCreationDate(DateParser.getCurrentParsedDate());
            childHome.persist(child);
            builder = Response.ok();
        }else{
            builder = Response.status(Response.Status.CONFLICT);
        }
        return builder.build();
    }

    @GET
    @Path("/login/{userEmail}/{userPassword}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserDataResponse getParentData(@PathParam("userEmail") String userEmail, @PathParam("userPassword") String userPassword){
        Parent parent = null;
        Child child = null;
        UserDataResponse response=new UserDataResponse();
        boolean parentFound = false;
        try {
            parent  = parentHome.findByEmail(userEmail);
            if(parent.getPassword().equals(userPassword)){
                response = new UserDataResponse(parent);
                response.setRole("parent");
                parentFound = true;
            }
        }catch (RuntimeException re) {
            log.info("PARENT NOT FOUND");
            response.setRole("none");
        }
        if(!parentFound){
            try {
                child = childHome.findByEmail(userEmail);
                if(child.getPassword().equals(userPassword)){
                    response = new UserDataResponse(child);
                    response.setRole("child");
                }
            }catch (RuntimeException re) {
                log.info("childHome NOT FOUND");
                response.setRole("none");
            }
        }
        return response;
    }
}
