package teumin.entity;

import java.util.ArrayList;

public class Category {
    public static ArrayList<String> getCategories() {
        ArrayList<String> categories = new ArrayList<>();
        categories.add("한식");
        categories.add("중식");
        categories.add("일식");
        categories.add("양식");
        // +
        return categories;
    }
}
