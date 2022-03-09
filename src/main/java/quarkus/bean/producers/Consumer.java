package quarkus.bean.producers;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class Consumer {

    /* Como não foi definido o escopo, é utilizado o padrão: @Dependent (O escopo será o mesmo do objeto onde será injetado) */
    @Inject
    double pi;

    /* */
    @Inject
    List<String> names;


    @PostConstruct
    void init() {
        System.out.println("[consumer] Valor de `pi`: " + pi);
        System.out.println("[consumer] Valor de `names`: " + Arrays.toString(names.toArray()));
    }


    public void teste() {
        System.out.println("[consumer] Inicializando Bean");
    }

}
