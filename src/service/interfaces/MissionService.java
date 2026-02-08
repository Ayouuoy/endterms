package service.interfaces;

import model.Mission;
import java.util.List;

public interface MissionService {
    void create(String name, int planetId);
    void update(int id, String name, int planetId);
    void delete(int id);
    Mission getById(int id);
    List<Mission> getAll();
}
