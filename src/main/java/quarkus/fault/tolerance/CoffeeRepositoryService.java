package quarkus.fault.tolerance;

import javax.enterprise.context.ApplicationScoped;
import java.util.*;
import java.util.stream.Collectors;

@ApplicationScoped
public class CoffeeRepositoryService {


    private Map<Integer, Coffee> coffeeList = new HashMap<>();

    public CoffeeRepositoryService() {
        coffeeList.put(1, Coffee.of(1, "Coffee1", "Colombia", 23));
        coffeeList.put(2, Coffee.of(1, "Coffee2", "Bolivia", 18));
        coffeeList.put(3, Coffee.of(1, "Coffee3", "Vietnam", 25));
    }

    public List<Coffee> getAllCoffees() {
        return new ArrayList<>(coffeeList.values());
    }

    public Coffee getCoffeeById(Integer id) {
        return coffeeList.get(id);
    }

    public List<Coffee> getRecommendations(Integer id) {

        if(id == null)
            return Collections.emptyList();

        return coffeeList.values().stream()
                .filter(coffee -> !id.equals(coffee.id))
                .limit(2)
                .collect(Collectors.toList());
    }


}
