package enums;

public enum RadioButtons {


    GOLD("Gold"), SILVER("Silver"), BRONZE("Bronze"), SELEN("Selen");

    public String name;
    public static int size = 4;

    RadioButtons(String name) {
        this.name = name;
    }
}
