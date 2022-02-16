package quarkus;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class QuarkusExamplo {


    private static final Logger log = Logger.getLogger(QuarkusExamplo.class);


    void onStart(@Observes StartupEvent event) {
        log.info("Applicação inicializada");
    }

    void onStop(@Observes ShutdownEvent event) {
        log.info("Applicação finalizada");
    }


}