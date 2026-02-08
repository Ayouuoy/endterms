package service;

import model.SalvageItem;
import repository.interfaces.CrudRepository;
import service.interfaces.SalvageItemService;

import java.util.List;

public class SalvageItemServiceI implements SalvageItemService {

    private final CrudRepository<SalvageItem> repository;

    public SalvageItemServiceI(CrudRepository<SalvageItem> repository) {
        this.repository = repository;
    }

    @Override
    public void create(SalvageItem item) {
        if (!item.isValid()) {
            throw new RuntimeException("Invalid salvage item");
        }
        repository.create(item);
    }

    @Override
    public SalvageItem getById(int id) {
        return repository.getById(id);
    }

    @Override
    public List<SalvageItem> getAll() {
        return repository.getAll();
    }

    @Override
    public void update(int id, SalvageItem item) {
        repository.update(id, item);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }
}
