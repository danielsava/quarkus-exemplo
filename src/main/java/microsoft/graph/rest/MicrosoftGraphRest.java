package microsoft.graph.rest;

import microsoft.graph.MicrosoftGraphService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/microsoft-graph/")
public class MicrosoftGraphRest {


    @Inject
    MicrosoftGraphService microsoftGraphService;



    @GET
    @Path("/tutorial")
    public void tutorial() {
        microsoftGraphService.mostrarMenu();
    }




}
