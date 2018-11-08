package JDI.enums;

public enum ColorsDropDown {

    COLORS("Colors"), RED("Red"), GREEN("Green"), BLUE("Blue"), YELLOW("Yellow");

    public String name;

    ColorsDropDown(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}