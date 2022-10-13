package com.axonactive.agileterm.api;

import com.axonactive.agileterm.entity.UserEntity;
import com.axonactive.agileterm.service.UserService;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path(UserResource.PATH)
public class UserResource {

    public static final String PATH = "/users";
    @Inject
    UserService userService;
    @Inject
    Logger log;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
//    public List<UserEntity> getAll() {
        return Response.ok(userService.getAll()).build();
//        return userService.getAll();
    }

    @GET
    @Path("/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserEntity getRoleFromUserName(@PathParam("username") String username) {
//        UserEntity newUser =
             return new UserEntity(null,username,null,null,null,userService.getRoleFromUserName(username));
//        return Response.ok(newUser).build();
    }


}
