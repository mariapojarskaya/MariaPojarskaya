package enums;

public enum DropDown {
    RED("Red"), GREEN("Green"),
    BLUE("Blue"), YELLOW("Yellow");

    public String name;
    public static String category = "Colors";

    DropDown(String name) {

        this.name = name;
    }
}
