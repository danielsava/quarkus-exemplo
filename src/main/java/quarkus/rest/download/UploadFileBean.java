package quarkus.rest.download;

import org.jboss.resteasy.reactive.PartType;
import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.multipart.FileUpload;

import javax.ws.rs.core.MediaType;
import java.io.File;

/**
 *   https://quarkus.io/guides/resteasy-reactive#handling-multipart-form-data
 *
 *      - Assuming an HTTP request containing a file upload and a form value containing a string description
 *        need to be handled, we could write a POJO that will hold this information like so:
 *
 */

public class UploadFileBean {


    // The name field will contain the data contained in the part of HTTP request called "description"
    // (because @RestForm does not define a value, the field name is used),
    // while the file field will contain data about the uploaded file in the image part of HTTP request.
    @RestForm
    @PartType(MediaType.TEXT_PLAIN)
    public String description;

    // FileUpload provides access to various metadata of the uploaded file.
    // If however all you need is a handle to the uploaded file, java.nio.file.Path or java.io.File could be used.
    @RestForm("image")
    public FileUpload file;

}
