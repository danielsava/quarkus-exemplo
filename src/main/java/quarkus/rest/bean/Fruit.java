package quarkus.rest.bean;

public class Fruit {

    public String name;

    public String desc;


    // Para a camada de serialização JSON em API REST(jackson ou json-b) é necessário um construtor padrão
    public Fruit() { }


    public Fruit(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

}
