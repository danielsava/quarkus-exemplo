package quarkus.bean.qualifiers;

import javax.enterprise.context.ApplicationScoped;


/* ApplicationScoped - Somente uma instância do bean será criada */
@ApplicationScoped
public class Translator {


    // @Inject
    // Instance<BeanQualquer> beans; - O CDI injeta todas as instâncias que encontrou do Bean. É uma lista, e a escolha de qual utilizar pode ser feita atravé do código (runtime)



    //private final TranslatorHelper helper;

    /*
       This is a constructor injection.
       In fact, this code would not work in regular CDI implementations where a bean
       with a normal scope must always declare a no-args constructor and the bean constructor must be annotated with @Inject.
       However, in Quarkus we detect the absence of no-args constructor and "add" it directly in the bytecode.
       It’s also not necessary to add @Inject if there is only one constructor present.

    Translator(TranslatorHelper helper) {
       this.helper = helper;
    }

    */





}
