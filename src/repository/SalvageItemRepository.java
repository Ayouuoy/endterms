package repository;

import model.SalvageItem;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import patterns.SalvageItemFactory;

import java.util.List;

@Repository
public class SalvageItemRepository {

    private final JdbcTemplate jdbc;

    public SalvageItemRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void create(SalvageItem item, int missionId) {
        jdbc.update(
                "INSERT INTO salvage_items(name, value, mission_id, type) VALUES (?,?,?,?)",
                item.getName(),
                item.getValue(),
                missionId,
                item.getType()
        );
    }

    public SalvageItem getById(int id) {
        return jdbc.queryForObject(
                "SELECT * FROM salvage_items WHERE id=?",
                (rs, _) -> SalvageItemFactory.create(
                        rs.getString("type"),
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("value")
                ),
                id
        );
    }

    public List<SalvageItem> getAll() {
        return jdbc.query(
                "SELECT * FROM salvage_items",
                (rs, _) -> SalvageItemFactory.create(
                        rs.getString("type"),
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("value")
                )
        );
    }

    public void delete(int id) {
        jdbc.update("DELETE FROM salvage_items WHERE id=?", id);
    }
}
