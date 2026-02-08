package model;

public class Planet extends Entity {

    private int hazardLevel;

    public Planet(int id, String name, int hazardLevel) {
        super(id, name);
        this.hazardLevel = hazardLevel;
    }

    public int getHazardLevel() {
        return hazardLevel;
    }

    @Override
    public boolean isValid() {
        return name != null && !name.isBlank()
                && hazardLevel >= 0 && hazardLevel <= 10;
    }

    @Override
    public String getType() {
        return "Planet";
    }
}
