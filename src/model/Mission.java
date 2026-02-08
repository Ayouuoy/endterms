package model;

public class Mission extends Entity {

    private int planetId;

    public Mission(int id, String name, int planetId) {
        super(id, name);
        this.planetId = planetId;
    }

    public int getPlanetId() {
        return planetId;
    }

    @Override
    public boolean isValid() {
        return name != null && !name.isBlank() && planetId > 0;
    }

    @Override
    public String getType() {
        return "Mission";
    }
}
