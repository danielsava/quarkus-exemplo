package quarkus.rest.jsonview;

import com.fasterxml.jackson.annotation.JsonView;

public class User {

    @JsonView(Views.Private.class)
    public int id;

    @JsonView(Views.Public.class)
    public String name;


    public User() { }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static User of(int id, String name) {
        return new User(id, name);
    }

}
