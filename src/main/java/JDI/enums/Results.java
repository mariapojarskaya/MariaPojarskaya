package JDI.enums;

public enum Results {

    SUMMARY("Summary: "),
    ELEMENTS("Elements: "),
    COLOR("Color: "),
    METAL("Metal: "),
    VEGETABLE("Vegetables: ");

    public String value;

    Results(String value) {
        this.value = value;
    }
}
