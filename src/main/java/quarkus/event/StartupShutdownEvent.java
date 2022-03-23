package quarkus.event;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.jboss.logging.Logger;
import quarkus.bean.producers.Consumer;
import quarkus.config.ConfigExample;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class StartupShutdownEvent {


    private static final Logger log = Logger.getLogger(StartupShutdownEvent.class);

    @Inject
    Consumer consumer;

    @Inject
    ConfigExample configExample;


    void onStart(@Observes StartupEvent event) {
        log.info("Applicação inicializada");
        consumer.teste();
        configExample.valores();
    }

    void onStop(@Observes ShutdownEvent event) {
        log.info("Applicação finalizada");
    }


}