package service.interfaces;

import model.Planet;
import java.util.List;

public interface PlanetService {
    void create(String name, int hazardLevel);
    void update(int id, String name, int hazardLevel);
    void delete(int id);
    Planet getById(int id);
    List<Planet> getAll();
}
