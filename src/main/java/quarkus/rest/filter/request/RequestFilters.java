package quarkus.rest.filter.request;

import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerRequestFilter;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.Optional;

/**
 *      Referência:
 *          - https://quarkus.io/guides/resteasy-reactive#request-or-response-filters
 *
 */

public class RequestFilters {

    // Aplica o filtro antes de encaminhar para os endpoint
    //@ServerRequestFilter(preMatching = true)
    public void preMatchingFilter(ContainerRequestContext requestContext) {
        if("yes".equals(requestContext.getHeaderString("Cheese")))
            requestContext.setRequestUri(URI.create("/cheese"));

    }

    /* Only allow GET methods for now */
    //@ServerRequestFilter
    public Optional<RestResponse<Void>> getFilter(ContainerRequestContext requestContext) {
        if(requestContext.getMethod().equals(HttpMethod.GET))
            return Optional.of(RestResponse.status(Response.Status.METHOD_NOT_ALLOWED));
        return Optional.empty();

    }


}
