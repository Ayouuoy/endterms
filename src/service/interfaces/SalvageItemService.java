package service.interfaces;

import model.SalvageItem;
import java.util.List;

public interface SalvageItemService {
    void create(SalvageItem item);
    SalvageItem getById(int id);
    List<SalvageItem> getAll();
    void update(int id, SalvageItem item);
    void delete(int id);
}
