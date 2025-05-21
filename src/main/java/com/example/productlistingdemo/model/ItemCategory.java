package com.example.productlistingdemo.model;

import java.util.Objects;

public class ItemCategory {
    private String name;

    public ItemCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Needed to ensure proper key behavior in HashMap and Thymeleaf rendering
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemCategory)) return false;
        ItemCategory that = (ItemCategory) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    // For rendering in Thymeleaf or debugging
    @Override
    public String toString() {
        return name;
    }
}