package quarkus.rest.exception.mapping;

import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

import javax.ws.rs.core.Response;


/**
 *
 *  https://quarkus.io/guides/resteasy-reactive#exception-mapping
 *
 *      "Exception mappers defined in REST endpoint classes will only be called if the exception is thrown
 *  in the same class. If you want to define global exception mappers, simply define them outside
 *  a REST endpoint class"
 *
 */

public class ExceptionMappers {

    @ServerExceptionMapper
    public RestResponse<String> mapException(UnknowException e) {
        return RestResponse.status(Response.Status.NOT_FOUND, "Unknown chesse: " + e.name);
    }

}
