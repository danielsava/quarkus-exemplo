package quarkus.rest.context.objects;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.SecurityContext;
import java.security.Principal;


/**
 *   Referência:
 *      - https://quarkus.io/guides/resteasy-reactive#accessing-context-objects
 *
 *
 */


@Path("context")
public class ContextResource {


    @Inject
    HttpHeaders httpHeaders;

    @Inject
    ResourceInfo resourceInfo;

    @Inject
    SecurityContext securityContext;



    /*
    As injeções poderiam ser feitoas pelo construtor também
    ContextResource(SecurityContext security) {
        this.securityContext = security;
    }
    */

    @GET
    public String userName() {
        Principal user = securityContext.getUserPrincipal();
        return user != null ? user.getName() : "<NOT LOGGED IN>";
    }


}
