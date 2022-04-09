package quarkus.rest.client;

import java.util.List;

/**
 *
 *      Referência:
 *          - https://quarkus.io/guides/rest-client-reactive#setting-up-the-model
 *
 *      "In this guide we will be demonstrating how to consume part
 *      of the REST API supplied by the stage.code.quarkus.io service.
 *
 *      Our first order of business is to set up the model we will be using,
 *      in the form of a Extension POJO"
 *
 *
 */

public class ClientExtensionBean {


    public String id;

    public String name;

    public String shortName;

    public List<String> keywords;


    @Override
    public String toString() {
        return "ClientExtensionBean{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", keywords=" + keywords +
                '}';
    }

}
