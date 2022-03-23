package quarkus.rest.download;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *  https://quarkus.io/guides/resteasy-reactive#handling-multipart-form-data
 *
 */

@Path("multipart")
public class FileResource {



    @GET
    @Produces(MediaType.MULTIPART_FORM_DATA)
    @Path("file")
    public DownloadFormDataBean getFile() {


        return null; // return something
    }


}

