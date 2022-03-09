package quarkus.bean.producers;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import java.util.ArrayList;
import java.util.List;


@ApplicationScoped
public class Producers {


    /* Field Producer */
    @Produces
    double pi = Math.PI;



    /* Method Producer */
    @Produces
    List<String> names() {
        List<String> names = new ArrayList<>();
        names.add("Andy");
        names.add("Adalbert");
        names.add("Joaquim");
        return names;
    }



}
