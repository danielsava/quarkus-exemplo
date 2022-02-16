package quarkus.bean;

import javax.enterprise.context.ApplicationScoped;


/* ApplicationScoped - Somente uma instância do bean será criada */
@ApplicationScoped
public class Translator {



    // @Inject
    // BeanQualquer bean; - Injeção de dependência comum


    // @Inject
    // Instance<BeanQualquer> beans; - O CDI injeta todas as instâncias que encontrou do Bean. Qualquer utilizar é resolvida no código.


    //@Counted
    String translate(String sentence) {
        return sentence;
    }


}
