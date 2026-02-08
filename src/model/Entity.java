package model;

public abstract class Entity {

    protected int id;
    protected String name;

    protected Entity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract boolean isValid();
    public abstract String getType();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
