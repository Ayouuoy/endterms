package repository;

import model.Mission;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MissionRepository {

    private final JdbcTemplate jdbc;

    public MissionRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void create(Mission m) {
        jdbc.update(
                "INSERT INTO missions(name, planet_id) VALUES (?,?)",
                m.getName(), m.getPlanetId()
        );
    }

    public Mission getById(int id) {
        return jdbc.queryForObject(
                "SELECT * FROM missions WHERE id=?",
                (rs, _) -> new Mission(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("planet_id")
                ),
                id
        );
    }

    public List<Mission> getAll() {
        return jdbc.query(
                "SELECT * FROM missions",
                (rs, _) -> new Mission(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("planet_id")
                )
        );
    }

    public void update(int id, String name) {
        jdbc.update(
                "UPDATE missions SET name=? WHERE id=?",
                name, id
        );
    }

    public void delete(int id) {
        jdbc.update("DELETE FROM missions WHERE id=?", id);
    }
}
