package service;

import model.Planet;
import repository.interfaces.CrudRepository;
import service.interfaces.PlanetService;

import java.util.List;

public class PlanetServiceI implements PlanetService {

    private final CrudRepository<Planet> repository;

    public PlanetServiceI(CrudRepository<Planet> repository) {
        this.repository = repository;
    }

    @Override
    public void create(String name, int hazardLevel) {
        Planet planet = new Planet(0, name, hazardLevel);

        if (!planet.isValid()) {
            throw new RuntimeException("Invalid planet data");
        }

        repository.create(planet);
    }

    @Override
    public void update(int id, String name, int hazardLevel) {
        Planet planet = new Planet(id, name, hazardLevel);
        repository.update(id, planet);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public Planet getById(int id) {
        return repository.getById(id);
    }

    @Override
    public List<Planet> getAll() {
        return repository.getAll();
    }
}
