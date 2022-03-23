package quarkus.rest.download;

import org.jboss.resteasy.reactive.MultipartForm;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 *  Referência:
 *     - https://quarkus.io/guides/resteasy-reactive#handling-multipart-form-data
 *
 *     IMPORTANTE:
 *      - For the time being, returning Multipart data is limited to be blocking endpoints. (Ou seja, não possui suporte no Reactive)
 *
 */

@Path("multipart")
public class FileResource {


    // Upload File
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Path("upload")
    public String form(@MultipartForm UploadFileBean uploadFileBean) { // The use of "@MultipartForm" is actually unnecessary as RESTEasy Reactive can infer this information from the use of @Consumes(MediaType.MULTIPART_FORM_DATA)

        return null; // return something
    }

    // Download File
    @GET
    @Produces(MediaType.MULTIPART_FORM_DATA)
    @Path("file")
    public DownloadFileBean getFile() {

        return null; // return something
    }


}

