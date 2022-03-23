package quarkus.rest;

import quarkus.rest.service.GreetingService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("greeting")
public class GreetingResource {


    @Inject
    GreetingService greetingService;


    @GET
    @Path("greeting/{name}")
    public String greeting(String name) {
        return greetingService.greeting(name);
    }

}
