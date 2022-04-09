package quarkus.rest.client;

import io.quarkus.logging.Log;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.Set;

@Path("/extension")
public class ClientExtensionsResource {


    // The client is injected with the @RestClient annotation instead of the usual CDI @Inject
    @RestClient
    ClientExtensionRest clientExtension;

    @GET
    @Path("/id/{id}")
    //@Blocking
    public Set<ClientExtensionBean> id(String id) { // @PathParam não é necessário especificar, é o default

        Set<ClientExtensionBean> resultado = clientExtension.geById(id, "header-teste");

        Log.info("[client-rest][extensios][resultado]: " + resultado);

        return resultado;
    }

    @GET
    @Path("/id-async/{id}")
    public Uni<Set<ClientExtensionBean>> idAsync(String id) {

        return clientExtension.getByIdAsync(id)
                .onFailure()
                    .retry()
                    .atMost(3);
    }


}
