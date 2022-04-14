package quarkus.fault.tolerance;

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;


/**
 *      SmallRye Fault Tolerance
 *          - https://quarkus.io/guides/smallrye-fault-tolerance
 *
 */

@Path("/coffee")
public class CoffeeResource {


    @Inject
    Logger log;

    @Inject
    CoffeeRepositoryService coffeeRepository;

    private AtomicLong counter = new AtomicLong(0);


    @GET
    @Retry(maxRetries = 4) // @Retry(maxRetries = 4, retryOn = IOException.class)
    public List<Coffee> coffees() {

        long started = System.currentTimeMillis();

        final Long invocationNumber = counter.getAndIncrement();

        try {

            maybeFailt(String.format("CoffeeResource#coffees() invocation #%d failed", invocationNumber));

            randomDelay();

            log.infof("CoffeeResource#coffees() invocation #%d returning successfully");

            return coffeeRepository.getAllCoffees();

        } catch (InterruptedException e) {
            log.errorf("CoffeeResource#recommendations() invocation #%d timed out after %d ms", invocationNumber, System.currentTimeMillis() - started);
            return null;
        }


    }

    @GET
    @Path("/{id}/recommendations")
    @Timeout(250)
    @Fallback(fallbackMethod = "fallbackRecommendations")
    public List<Coffee> recommendations(@PathParam("id") int id) {

        long started = System.currentTimeMillis();
        final long invocationNumber = counter.getAndIncrement();

        try {
            randomDelay();
            log.infof("CoffeeResource#recommendations() invocation #%d returning successfully", invocationNumber);
            return coffeeRepository.getRecommendations(id);
        } catch (InterruptedException e) {
            log.errorf("CoffeeResource#recommendations() invocation #%d timed out after %d ms", invocationNumber, System.currentTimeMillis() - started);
            return null;
        }


    }


    public List<Coffee> fallbackRecommendations(int id) {
        log.info("Falling back to RecommendationResource#fallbackRecommendations()");
        return Collections.singletonList(coffeeRepository.getCoffeeById(1));
    }


    private void maybeFailt(String failureLogMessage) {
        if(new Random().nextBoolean()) {
            log.error(failureLogMessage);
            throw new RuntimeException("Resource Failure");
        }
    }

    private void randomDelay() throws InterruptedException {
        Thread.sleep(new Random().nextInt(500));
    }

}
