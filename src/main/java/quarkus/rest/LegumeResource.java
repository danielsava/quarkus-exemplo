package quarkus.rest;

import quarkus.rest.bean.Fruit;
import quarkus.rest.bean.Legume;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;


@Path("/legumes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LegumeResource {


    private final Set<Legume> legumes = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));


    @PostConstruct
    void init() {
        legumes.add(new Legume("Carrot", "Root vegetable"));
        legumes.add(new Legume("Zucchini", "Summer squash"));
    }


    // Caso crie um executável nativo, em virtude do 'Response' os objetos 'legumes' não serão serializados em Json
    // Neste caso, irá retornar uma lista VAZIA. Para contornar este erro, adicionar a anotação @RegisterForReflection
    // na entidade 'Legume'
    @GET
    public Response list() {
        return Response.ok(legumes).build();
    }




}
