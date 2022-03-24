package quarkus.rest.profile;

import io.quarkus.arc.profile.IfBuildProfile;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@IfBuildProfile("app1")
@Path("profile")
public class ProfileResourceForApp1Only {

    @GET
    @Path("sayHello")
    public String sayHello() {
        return "Hello Profile App1";
    }


}
