package enums;

public enum CheckBoxes {

    WATER("Water"), EARTH("Earth"), WIND("Wind"), FIRE("Fire");

    public String name;
    public static int size = 4;

    CheckBoxes(String name) {
        this.name = name;
    }
}
