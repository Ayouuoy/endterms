package patterns;

import model.Mission;

public class MissionBuilder {

    private int id;
    private String name;
    private int planetId;

    public MissionBuilder id(int id) {
        this.id = id;
        return this;
    }

    public MissionBuilder name(String name) {
        this.name = name;
        return this;
    }

    public MissionBuilder planetId(int planetId) {
        this.planetId = planetId;
        return this;
    }

    public Mission build() {
        return new Mission(id, name, planetId);
    }
}
