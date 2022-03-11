package microsoft.graph.producer.qualifiers;

import javax.inject.Qualifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



 /*
    Qualifiers are annotations that help the container to distinguish beans that implement the same type
    A qualifier type is a Java annotation defined as @Retention(RUNTIME) and annotated
    with the @javax.inject.Qualifier meta-annotation
 */


@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE})
public @interface Tutorial { }
