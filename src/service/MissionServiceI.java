package service;

import model.Mission;
import repository.interfaces.CrudRepository;
import service.interfaces.MissionService;

import java.util.List;

public class MissionServiceI implements MissionService {

    private final CrudRepository<Mission> repository;

    public MissionServiceI(CrudRepository<Mission> repository) {
        this.repository = repository;
    }

    @Override
    public void create(String name, int planetId) {
        Mission mission = new Mission(0, name, null);

        if (!mission.isValid()) {
            throw new RuntimeException("Invalid mission data");
        }

        repository.create(mission);
    }

    @Override
    public void update(int id, String name, int planetId) {
        Mission mission = new Mission(id, name, null);
        repository.update(id, mission);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public Mission getById(int id) {
        return repository.getById(id);
    }

    @Override
    public List<Mission> getAll() {
        return repository.getAll();
    }
}
