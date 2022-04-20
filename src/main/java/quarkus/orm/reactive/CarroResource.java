package quarkus.orm.reactive;

//@Path("/carros")
//@ApplicationScoped
public class CarroResource {

    /*
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
    */

}
