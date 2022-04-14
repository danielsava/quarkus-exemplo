package quarkus.fault.tolerance;

public class Coffee {

    public Integer id;

    public String name;

    public String countryOfOrigin;

    public Integer price;

    public Coffee() { }

    public Coffee(Integer id, String name, String countryOfOrigin, Integer price) {
        this.id = id;
        this.name = name;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
    }

    public static Coffee of(Integer id, String name, String countryOfOrigin, Integer price) {
        return new Coffee(id, name, countryOfOrigin, price);
    }

}
