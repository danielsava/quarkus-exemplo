package quarkus.rest.exception.mapping;

public class UnknowException extends RuntimeException {

    public final String name;

    public UnknowException(String name) {
        this.name = name;
    }

}
