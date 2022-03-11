package microsoft.graph.rest;

import microsoft.graph.MicrosoftGraphTutorialService;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/microsoft/tutorial")
public class MicrosoftGraphTutorialRest {

    private static final Logger log = Logger.getLogger(MicrosoftGraphTutorialRest.class);

    @Inject
    MicrosoftGraphTutorialService tutorialService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/token")
    public String userAccessToken() {

        String token = tutorialService.userAccessToken();
        log.info("Tutorial UserAccessToken: " + token);
        return token;
    }




}
