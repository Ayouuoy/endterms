import controller.PlanetController;
import repository.PlanetRepository;
import service.PlanetServiceI;
import utils.ReflectionUtils;
import utils.SortingUtils;
import model.Planet;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        PlanetRepository repo = new PlanetRepository();
        PlanetServiceI service = new PlanetServiceI(repo);
        PlanetController controller = new PlanetController(service);

        controller.createPlanet("Damir", 5);
        controller.createPlanet("KairatNurtas", 7);

        List<Planet> planets = service.getAll();

        SortingUtils.sort(planets,
                (a,b) -> a.getName().compareTo(b.getName()));

        planets.forEach(p -> System.out.println(p.getName()));

        ReflectionUtils.inspect(planets.get(0));
    }
}
