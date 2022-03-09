package quarkus;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.jboss.logging.Logger;
import quarkus.bean.producers.Consumer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class QuarkusExamplo {


    private static final Logger log = Logger.getLogger(QuarkusExamplo.class);

    @Inject
    Consumer consumer;


    void onStart(@Observes StartupEvent event) {
        log.info("Applicação inicializada");
        consumer.teste();
    }

    void onStop(@Observes ShutdownEvent event) {
        log.info("Applicação finalizada");
    }


}