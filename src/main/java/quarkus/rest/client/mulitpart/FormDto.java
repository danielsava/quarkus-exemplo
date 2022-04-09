package quarkus.rest.client.mulitpart;

import org.jboss.resteasy.reactive.PartType;

import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;
import java.io.File;

public class FormDto {

    /*
     *   Observações:
     *
     *      - Sobre envio de arquivos:
     *          - Files sent in multipart responses can only be parsed to 'File', 'Path' and 'FileDownload'
     *          - Each field of the response type has to be annotated with @PartType - fields without this annotation are ignored
     *
     *     - Sobre os arquivos que foram 'baixados':
     *          - The files you download are not automatically removed and can take up a lot of disk space.
     *            Consider removing the files when you are done working with them.
     *
     *
     */
    @FormParam("file") // Ou pode ser utilizado o @RestForm para utilizar o mesmo nome de atributo da classe para o atributo do formulario
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    public File file;// Fields specified as File, Path, byte[] or Buffer are sent as files; as binary files for @PartType(MediaType.APPLICATION_OCTET_STREAM), as text files for other content types.

    @FormParam("otherField")
    @PartType(MediaType.TEXT_PLAIN)
    public String textProperty;


}
