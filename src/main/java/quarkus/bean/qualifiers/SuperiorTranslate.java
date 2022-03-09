package quarkus.bean.qualifiers;


import javax.enterprise.context.ApplicationScoped;


 /*
    The qualifiers of a bean are declared by annotating the:
      - Bean class
      - Producer method
      - Field with the qualifier types:
 */

@Superior
@ApplicationScoped
public class SuperiorTranslate extends Translator {


}

/*

 Observação importante

    This bean would be assignable to @Inject @Superior Translator
    and @Inject @Superior SuperiorTranslator
    but not to @Inject Translator.
    The reason is that @Inject Translator is automatically transformed to @Inject @Default Translator during
    typesafe resolution.
    And since our SuperiorTranslator does not declare @Default only the original Translator bean is assignable.

 */
