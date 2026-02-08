package model;

public abstract class SalvageItem extends Entity {

    protected double value;

    protected SalvageItem(int id, String name, double value) {
        super(id, name);
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
