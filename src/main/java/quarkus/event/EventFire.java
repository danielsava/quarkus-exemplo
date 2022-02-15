package quarkus.event;


import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

@ApplicationScoped
public class EventFire {


    @Inject
    Event<EventoBean> evento;

    void doSomeThing() {
        evento.fire(new EventoBean());
    }

}
