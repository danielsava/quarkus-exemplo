package quarkus.rest.negotiation;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 *
 *      Referência:
 *          - https://quarkus.io/guides/resteasy-reactive#negotiation
 *
 *      "One of the main ideas of REST (and HTTP) is that your resource is independent from its representation,
 *      and that both the client and server are free to represent their resources in as many media types
 *      as they want (json, text_plan, etc)"
 *
 */

@Path("negotiated")
public class NegotiationResource {


    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN}) // Aqui estão as opções de negociação que o client pode obter, basta especifiar
    public FroMage get() {
        return new FroMage("Morbier");
    }

    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public FroMage putString(String cheese) {
        return new FroMage(cheese);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public FroMage putJson(FroMage froMage) {
        return froMage;
    }


}
