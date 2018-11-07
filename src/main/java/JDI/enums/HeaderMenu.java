package JDI.enums;

public enum HeaderMenu {

    HOME("HOME"),
    CONTACT_FORM("CONTACT FORM"),
    SERVICE("SERVICE"),
    METALS_AND_COLORS("METALS & COLORS");

    public String description;

    HeaderMenu(String descr) {
        this.description = descr;
    }

    @Override
    public String toString() {
        return description;
    }
}
