package quarkus.rest;

import quarkus.rest.bean.Fruit;

import javax.annotation.PostConstruct;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;


/**
 *
 *    @Produces e @Consumes default com serialização JSON:
 *
 *      Sobre application/json (objetos da app), String (text/plan) e File (application/octet-stream)
 *
 *      When a JSON extension is installed such as quarkus-resteasy-jackson or quarkus-resteasy-jsonb,
 *      Quarkus will use the application/json media type by default for most return values,
 *      unless the media type is explicitly set via @Produces or @Consumes annotations
 *      (there are some exceptions for well known types, such as String and File, which default to text/plain
 *      and application/octet-stream respectively).
 *
 *      If you don’t want JSON by default you can set quarkus.resteasy-json.default-json=false and the
 *      default will change back to being auto-negotiated. If you set this you will need to
 *      add @Produces(MediaType.APPLICATION_JSON) and @Consumes(MediaType.APPLICATION_JSON)
 *      to your endpoints in order to use JSON.
 *
 *
 *    Mapeamento de Objetos/JSON (ObjectMapper)
 *
 *    - Dates and Times
 *       Furthermore, the ObjectMapper is configured to format dates and time in ISO-8601
 *       (by disabling the SerializationFeature.WRITE_DATES_AS_TIMESTAMPS feature).
 *
 *       The default behaviour of Jackson can be restored by setting quarkus.jackson.write-dates-as-timestamps=true
 *       in your application.properties. If you want to change the format for a single field,
 *       you can use the @JsonFormat annotation.
 *
 *
 */



@Path("/fruits")
public class FruitResource {


    private final Set<Fruit> fruits = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));


    @PostConstruct
    private void init() {
        fruits.add(new Fruit("Apple", "Winter fruit"));
        fruits.add(new Fruit("Pineapple", "Tropical fruit"));
    }


    @GET
    public Set<Fruit> list() {
        return fruits;
    }


    @POST
    public Set<Fruit> add(Fruit fruit) {
        fruits.add(fruit);
        return fruits;
    }


    @DELETE
    public Set<Fruit> delete(Fruit fruit) {
        fruits.removeIf(existingFruit -> existingFruit.name.equalsIgnoreCase(fruit.name));
        return fruits;
    }


}
