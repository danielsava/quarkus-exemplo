package quarkus.rest.async;


import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *      Endpoints Async / Reactive / NoBlocking (Event Loop)
 *
 *       - If your endpoint method needs to accomplish an asynchronous or reactive task before being able to answer,
 *         you can declare your method to return the Uni type (from Mutiny).
 *
 *       -
 *
 *
 *
 *
 */

@Path("async")
public class AsyncResource {


    // This allows you to not block the event-loop thread while the book is being fetched from the database,
    // and "ALLOWS QUARKUS TO SERVE MORE REQUESTS" until your book is ready to be sent to the client
    // and terminate this request.
    @GET
    public Uni<Book> getBookAsync() {
        return Uni.createFrom().item(Book.of(1, "Livro Teste"));
        // Book.findByIsbn("978-2081229297")
    }



    /**
     *   Streaming Support
     *
     *     - If you want to stream your response element by element, you can make your endpoint method return
     *       a Multi type (from Mutiny). This is especially useful for streaming text or binary data.
     *
     */

    //@Inject
    //@Channel("log-out")
    //Multi<String> logs;

    public Multi<String> streamLogs() {
        return null; // return logs;

        // obs: Response filters are not invoked on streamed responses, because they would give a false
        // impression that you can set headers or HTTP status codes, which is not true after the initial response.
    }


}
