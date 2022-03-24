package quarkus.rest.jsonview;

import com.fasterxml.jackson.annotation.JsonView;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("jsonview")
public class JsonViewResource {

    @GET
    @Path("public")
    @JsonView(Views.Public.class)
    public User userPublic() {
        return User.of(1, "Tobias");
    }

    @GET
    @Path("private")
    @JsonView(Views.Private.class)
    public User userPrivate() {
        return User.of(1, "Tobias");
    }

}
