package quarkus.rest.filter.response;


import org.jboss.resteasy.reactive.server.ServerResponseFilter;

import javax.ws.rs.container.ContainerResponseContext;

/**
 *      Referência:
 *          - https://quarkus.io/guides/resteasy-reactive#request-or-response-filters
 *
 */

public class ResponseFilters {

    // Caso o corpo do response seja uma string, vai transformar todas em UpperCase
    //@ServerResponseFilter
    public void getFilter(ContainerResponseContext responseContext) {
        Object entity = responseContext.getEntity();
        if(entity instanceof String)
            responseContext.setEntity(((String) entity).toUpperCase());
    }



}
