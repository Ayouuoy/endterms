package patterns;

import model.*;

public class SalvageItemFactory {

    public static SalvageItem create(
            String type,
            int id,
            String name,
            double value
    ) {
        if (type.equalsIgnoreCase("Artifact")) {
            return new Artifact(id, name, value);
        }
        if (type.equalsIgnoreCase("Scrap")) {
            return new Scrap(id, name, value);
        }
        throw new IllegalArgumentException("Unknown salvage type");
    }
}
