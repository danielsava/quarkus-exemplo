package quarkus.reactive.crud;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Uni;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/carros")
//@ApplicationScoped
public class CarroResource {

    @GET
    public Uni<List<Carro>> get() {
        return Carro.listAll(Sort.by("nome"));
    }

    @GET
    @Path("/{id}")
    public Uni<Carro> getSingle(Long id) {
        return Carro.findById(id);
    }

    @POST
    public Uni<Response> create(Carro carro) {
        return Panache.<Carro>withTransaction(carro::persist)
                .onItem()
                .transform(inserted -> Response.created(URI.create("/carros/" + inserted.id)).build())
                ;
    }


}
