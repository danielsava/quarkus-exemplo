package quarkus.rest;

import microsoft.graph.MicrosoftGraphService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/microsoft")
public class MicrosoftGraphRest {


    @Inject
    MicrosoftGraphService microsoftGraphService;

    @GET
    @Path("/app")
    public void greeting() {
        microsoftGraphService.mostrarMenu();
    }

}
