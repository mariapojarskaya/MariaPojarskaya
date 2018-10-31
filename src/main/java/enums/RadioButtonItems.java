package enums;

public enum RadioButtonItems {

    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    public String displayName;
    public int counter;
    public String value;

    RadioButtonItems(String name){
        displayName = name;
    }

    public static RadioButtonItems getRadioButtonItems(String displayName) {
        if (displayName.equals(GOLD.displayName)) {
            return GOLD;
        } else if (displayName.equals(SILVER.displayName)) {
            return SILVER;
        } else if (displayName.equals(BRONZE.displayName)) {
            return BRONZE;
        } else if (displayName.equals(SELEN.displayName)) {
            return SELEN;
        } else {
            throw new UnsupportedOperationException("Enum wasn't found!");
        }
    }
}
