package quarkus.rest.negotiation;

import com.fasterxml.jackson.annotation.JsonCreator;

public class FroMage {

    public String name;

    @JsonCreator
    public FroMage(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cheese: " + name;
    }

}
