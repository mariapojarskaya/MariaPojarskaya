package enums;

import java.util.ArrayList;
import java.util.List;

public enum ServiceItems {
    SUPPORT("Support"),
    DATES("Dates"),
    COMPLEX_TABLE("Complex Table"),
    SIMPLE_TABLE("Simple Table"),
    USER_TABLE("User Table"),
    TABLE_WITH_PAGES("Table with pages"),
    DIFFERENT_ELEMENTS("Different elements"),
    PERFORMANCE("Performance");



    public String description;

//    public String getTitle() {
//
////        return serviceItemTitle;
//    }

    ServiceItems(String description) {

        this.description = description;
    }

    public static List<String> getServiceItemTitles() {
        List<String> listServiceItems = new ArrayList<>();
        for (ServiceItems items: ServiceItems.values()) {
            listServiceItems.add(items.description.toUpperCase());
        }
        return listServiceItems;
    }

}
