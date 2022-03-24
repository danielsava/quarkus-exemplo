package quarkus.rest.exception;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;

@Path("exception/{name}")
public class ExceptionResource {


    @GET
    public String exception(String name) {

        if(name.length() == 3)
            throw new BadRequestException(); // send a 400
        if(!name.equalsIgnoreCase("asdrubal"))
            throw new NotFoundException("Nome desconhecido: " + name); // send a 404

        return  name + " é o cara!";

    }


}
