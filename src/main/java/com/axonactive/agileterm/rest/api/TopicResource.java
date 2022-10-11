package com.axonactive.agileterm.rest.api;

import com.axonactive.agileterm.service.TopicService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path(TopicResource.PATH)
public class TopicResource {
    public static final String PATH = "/topics";
    @Inject
    TopicService topicService;


    @GET
    @Produces({MediaType.APPLICATION_JSON})

    public Response getAll() {
        return Response.ok(topicService.getAll()).build();
    }

}

