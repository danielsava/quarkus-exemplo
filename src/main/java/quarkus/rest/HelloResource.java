package quarkus.rest;

import org.jboss.resteasy.reactive.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("hello")
public class HelloResource {

    @GET
    public String hello() {
        return "hello";
    }

    @GET
    @Path("{name}/{age:\\d+}")
    public String personalisedHello(String name, int age) {
        return "Hello " + name + " is your age really " + age + "?";
    }


    /**
     *
     *  - Modelo da chamada (http://localhost:8080/api/hello;variant=goat/tomme?age=matured)
     *
     *      POST /cheeses;variant=goat/tomme?age=matured HTTP/1.1
     *      Content-Type: application/x-www-form-urlencoded
     *      Cookie: level=hardcore
     *      X-Cheese-Secret-Handshake: fist-bump
     *
     *      smell=strong
     *
     */
    @GET
    @Path("{type}")
    public String allParams(@RestPath String type, // The @RestPath annotation is optional: any parameter whose name matches an existing URI template variable will be automatically assumed to have @RestPath
                            @RestMatrix String variant,
                            @RestQuery String age,
                            @RestCookie String level,
                            @RestHeader ("X-Cheese-Secret-Handshake") String secretHandshake,
                            @RestForm String smell) {
        return type + "/" + variant + "/" + age + "/" + level + "/" + secretHandshake + "/" + smell;
    }

}
