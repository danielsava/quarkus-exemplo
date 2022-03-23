package quarkus.rest.response;

import org.jboss.resteasy.reactive.ResponseHeader;
import org.jboss.resteasy.reactive.ResponseStatus;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.RestResponse.ResponseBuilder;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;

@Path("response")
public class ResponseExamples {



    @GET
    public RestResponse<String> hello() {

        // HTTP Ok status with text/plan content type
        return ResponseBuilder.ok("Hello World", MediaType.TEXT_PLAIN_TYPE)
                // set a response header
                .header("X-FromAge", "Camembert")
                // send a new cookie
                .cookie(new NewCookie("Flavour", "praliné"))
                // end of builder API
                .build();

        // Obs: You can also use the JAX-RS type Response but it is not strongly typed to your entity.
    }


    // Using Annotations

    @GET
    @Path("annotations")
    @ResponseStatus(201)
    @ResponseHeader(name = "X-FroMage", value = "Camembert")
    public String withAnnotations() {
        return "Hello Responde, with annotations";
    }


}
