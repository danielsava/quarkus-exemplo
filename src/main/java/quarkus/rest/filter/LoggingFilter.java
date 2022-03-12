package quarkus.rest.filter;

import io.quarkus.logging.Log;
import io.vertx.core.http.HttpServerRequest;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 *
 *      Documentação:
 *        - https://quarkus.io/guides/rest-json
 *
 *
 */

@Provider
public class LoggingFilter implements ContainerRequestFilter {


    @Context
    UriInfo uriInfo;

    @Context
    HttpServerRequest request;

    @Override
    public void filter(ContainerRequestContext context) throws IOException {

        final String method = context.getMethod();
        final String path = uriInfo.getPath();
        final String address = request.remoteAddress().toString();

        Log.infof("[LoggingFilter] Request %s %s from IP %s", method, path, address);

    }

}
