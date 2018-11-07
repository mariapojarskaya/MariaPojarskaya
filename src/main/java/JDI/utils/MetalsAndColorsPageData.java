package JDI.utils;


public class MetalsAndColorsPageData {

    private int[] summary;
    private String[] elements;
    private String color;
    private String metals;
    private String[] vegetables;

    public MetalsAndColorsPageData(int[] summary, String[] elements, String color, String metals, String[] vegetables) {
        this.summary = summary;
        this.elements = elements;
        this.color = color;
        this.metals = metals;
        this.vegetables = vegetables;
    }

    public int[] getSummary() {
        return summary;
    }

    public String[] getElements() {
        return elements;
    }

    public String getColor() {
        return color;
    }

    public String getMetals() {
        return metals;
    }

    public String[] getVegetables() {
        return vegetables;
    }
}
