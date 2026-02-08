package repository;

import model.Planet;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlanetRepository {

    private final JdbcTemplate jdbc;

    public PlanetRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void create(Planet p) {
        jdbc.update(
                "INSERT INTO planets(name, hazard_level) VALUES (?,?)",
                p.getName(), p.getHazardLevel()
        );
    }

    public Planet getById(int id) {
        return jdbc.queryForObject(
                "SELECT * FROM planets WHERE id=?",
                (rs, _) -> new Planet(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("hazard_level")
                ),
                id
        );
    }

    public List<Planet> getAll() {
        return jdbc.query(
                "SELECT * FROM planets",
                (rs, _) -> new Planet(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("hazard_level")
                )
        );
    }

    public void update(int id, String name, int hazard) {
        jdbc.update(
                "UPDATE planets SET name=?, hazard_level=? WHERE id=?",
                name, hazard, id
        );
    }

    public void delete(int id) {
        jdbc.update("DELETE FROM planets WHERE id=?", id);
    }
}
