package quarkus.rest.download;

import org.jboss.resteasy.reactive.PartType;
import org.jboss.resteasy.reactive.RestForm;

import javax.ws.rs.core.MediaType;
import java.io.File;

/**
 *   https://quarkus.io/guides/resteasy-reactive#handling-multipart-form-data
 *
 */

public class DownloadFileBean {


    @RestForm
    public String name;

    @RestForm
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    public File file;

}
