package quarkus.rest.exception.mapping;

import javax.enterprise.context.ApplicationScoped;
import java.util.Map;

@ApplicationScoped
public class CheeseService {


    private static final Map<String, String> cheeses = Map.of(
            "camembert", "Camembert is a very nice cheese",
            "gouda", "Gouda is acceptable too"
    );

    public String findCheese(String name) {
        String ret = cheeses.get(name);
        if(ret != null)
            return ret;
        throw new UnknowException(name);
    }

}
