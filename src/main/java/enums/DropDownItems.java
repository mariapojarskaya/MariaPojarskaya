package enums;

public enum DropDownItems {

    YELLOW("Yellow"),
    BLUE("Blue"),
    GREEN("Green"),
    RED("Red");

    public String displayName;

    DropDownItems(String name){
        displayName = name;
    }

    public static DropDownItems getDropDownItems(String displayName) {
        if (displayName.equals(YELLOW.displayName)) {
            return YELLOW;
        } else if (displayName.equals(BLUE.displayName)) {
            return BLUE;
        } else if (displayName.equals(GREEN.displayName)) {
            return GREEN;
        } else if (displayName.equals(RED.displayName)) {
            return RED;
        } else {
            throw new UnsupportedOperationException("Enum wasn't found!");
        }
    }
}
