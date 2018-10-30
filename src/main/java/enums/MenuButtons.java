package enums;

public enum MenuButtons {
    SUPPORT("SUPPORT"),
    DATES("DATES"),
    COMPLEX_TABLE("COMPLEX TABLE"),
    SIMPLE_TABLE("SIMPLE TABLE"),
    TABLES_WITH_PAGES("TABLES WITH PAGES"),
    DIFFERENT_ELEMENTS("DIFFERENT ELEMENTS");

    public String name;

    MenuButtons(String name) {
        this.name = name;
    }
}