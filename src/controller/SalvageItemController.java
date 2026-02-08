package controller;

import model.SalvageItem;
import service.SalvageItemServiceI;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salvage")
public class SalvageItemController {

    private final SalvageItemServiceI service;

    public SalvageItemController(SalvageItemServiceI service) {
        this.service = service;
    }

    @PostMapping
    public void create(
            @RequestBody SalvageItem item,
            @RequestParam int missionId
    ) {
        service.create(item, missionId);
    }

    @GetMapping("/{id}")
    public SalvageItem getById(@PathVariable int id) {
        return service.getById(id);
    }

    @GetMapping
    public List<SalvageItem> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
