package enums;

public enum Urls {

    HOME_PAGE_URL("https://epam.github.io/JDI/index.html");

    private String url;

    public String getUrl() {
        return url;
    }

    Urls(String url) {
        this.url = url;
    }
}