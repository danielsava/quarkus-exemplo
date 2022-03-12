package quarkus.rest.bean;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection // Ler anotação no endpoint em LegumeResource
public class Legume {


    public String name;

    public String desc;


    public Legume() {
    }

    public Legume(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

}
