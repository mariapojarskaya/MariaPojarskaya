package enums;

public enum CheckBoxItems {

    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    public final String displayName;

    CheckBoxItems(String name) {
        displayName = name;
    }

    public static CheckBoxItems getCheckBoxItems(String displayName) {
        if (displayName.equals(WATER.displayName)) {
            return WATER;
        } else if (displayName.equals(EARTH.displayName)) {
            return EARTH;
        } else if (displayName.equals(WIND.displayName)) {
            return WIND;
        } else if (displayName.equals(FIRE.displayName)) {
            return FIRE;
        } else {
            throw new UnsupportedOperationException("Enum wasn't found!");
        }
    }
}
