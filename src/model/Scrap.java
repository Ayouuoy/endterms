package model;

public class Scrap extends SalvageItem {

    public Scrap(int id, String name, double value) {
        super(id, name, value);
    }

    @Override
    public boolean isValid() {
        return value > 0;
    }

    @Override
    public String getType() {
        return "SCRAP";
    }
}
