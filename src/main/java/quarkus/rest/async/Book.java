package quarkus.rest.async;

public class Book {


    public int id;

    public String name;


    public Book() { }

    public Book(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Book of(int id, String name) {
        return new Book(id, name);
    }

}
