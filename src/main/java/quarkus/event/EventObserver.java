package quarkus.event;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class EventObserver {


    void ontTaskCompleted(@Observes EventoBean evento) {

    }

}
