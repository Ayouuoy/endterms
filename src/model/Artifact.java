package model;

public class Artifact extends SalvageItem {

    public Artifact(int id, String name, double value) {
        super(id, name, value);
    }

    @Override
    public boolean isValid() {
        return value > 1000;
    }

    @Override
    public String getType() {
        return "ARTIFACT";
    }
}
