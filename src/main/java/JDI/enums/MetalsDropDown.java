package JDI.enums;

public enum MetalsDropDown {

    METALS("Metals"), GOLD("Gold"), SILVER("Silver"), BRONZE("Bronze"), SELEN("Selen");

    public String name;

    MetalsDropDown(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}