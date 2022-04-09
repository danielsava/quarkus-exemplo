package quarkus.rest.client;

import io.quarkus.rest.client.reactive.ClientExceptionMapper;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.MultipartForm;
import quarkus.rest.client.headers.RequestUUIDHeaderFactory;
import quarkus.rest.client.mulitpart.FormDto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Set;


/**
 *
 *      Referência:
 *          - https://quarkus.io/guides/rest-client-reactive#setting-up-the-model
 *
 *      "In this guide we will be demonstrating how to consume part of the REST API
 *      supplied by the 'stage.code.quarkus.io' service."
 *
 *      "When the quarkus-rest-client-reactive-jackson extension is installed,
 *      Quarkus will use the application/json media type by default for most return values,
 *      unless the media type is explicitly set via @Produces or @Consumes annotations"
 *
 *
 */

@Path("/extensions")
@RegisterRestClient(configKey = "extension-api")
@RegisterClientHeaders(RequestUUIDHeaderFactory.class)
@ClientHeaderParam(name = "my-header", value = "constant-header-value")
@ClientHeaderParam(name = "computed-header", value = "{quarkus.rest.client.headers.HeaderUtil.getHeaderUtil}")
public interface ClientExtensionRest {


    //  Exemplo do resultado da execução deste client:
    //     - https://stage.code.quarkus.io/api/extensions?id=<valor_string_id>
    @GET
    @ClientHeaderParam(name = "header-from-properties", value = "${exemplo.rest.client.header.value}")
    Set<ClientExtensionBean> geById(@QueryParam("id") String id, @HeaderParam("jaxrs-style-header") String headerValue);


    @GET
    @Path("/stream/{stream}")
    Set<ClientExtensionBean> getByStream(@PathParam("stream") String stream, @QueryParam("id") String id);


    /*
     *   Async (event-loop)
     *     This means that the idAsync method will be invoked on the event loop,
     *     i.e. will not get offloaded to a worker pool thread and thus reducing hardware resource utilization.
     */
    @GET
    Uni<Set<ClientExtensionBean>> getByIdAsync(@QueryParam("id") String id);


    /* MultiPart */
    @POST
    @Path("/binary")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    String sendMultipart(@MultipartForm FormDto formDto); /* envia arquivos */

    @GET
    @Path("/get-file")
    @Produces(MediaType.MULTIPART_FORM_DATA)
    FormDto obterArquivo(); /* recebe arquivos */


    /* Response Exception Mapper: Mapea as respostas, das chamadas feitas pelo client, para alguma exception. */
    @ClientExceptionMapper
    static RuntimeException toException(Response response) {
        if(response.getStatus() == 500)
            return new RuntimeException("Th remote service responded with HTTP 500");
        return null;
    }


}
