package JDI.enums;

public enum Nature {

    WATER("Water"), EARTH("Earth"), WIND("Wind"), FIRE("Fire");

    public String name;

    Nature(String name) {

        this.name = name;
    }

    @Override
    public String toString() {

        return name;
    }
}