package controller;

import model.Mission;
import service.MissionServiceI;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missions")
public class MissionController {

    private final MissionServiceI service;

    public MissionController(MissionServiceI service) {
        this.service = service;
    }

    @PostMapping
    public void create(@RequestBody Mission m) {
        service.create(m);
    }

    @GetMapping("/{id}")
    public Mission getById(@PathVariable int id) {
        return service.getById(id);
    }

    @GetMapping
    public List<Mission> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Mission m) {
        service.update(id, m.getName());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
