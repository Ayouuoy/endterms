package controller;

import model.Planet;
import service.PlanetServiceI;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planets")
public class PlanetController {

    private final PlanetServiceI service;

    public PlanetController(PlanetServiceI service) {
        this.service = service;
    }

    @PostMapping
    public void create(@RequestBody Planet p) {
        service.create(p);
    }

    @GetMapping("/{id}")
    public Planet getById(@PathVariable int id) {
        return service.getById(id);
    }

    @GetMapping
    public List<Planet> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Planet p) {
        service.update(id, p.getName(), p.getHazardLevel());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
