package quarkus.rest.exception.mapping;

import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("cheese")
public class CheeseResource {

    @Inject
    CheeseService cheeseService;

    /* Mapping é applicado somente no escopo desta classe. Sobrescreve os escopos globais
    @ServerExceptionMapper
    public RestResponse<String> mapException(UnknowException x) {
        return RestResponse.status(Response.Status.NOT_FOUND, "Unknown cheese: " + x.name);
    }
    */

    @GET
    @Path("{name}")
    public String find(String name) {
        if(name == null)
            throw new BadRequestException();
        return cheeseService.findCheese(name);
    }


}
