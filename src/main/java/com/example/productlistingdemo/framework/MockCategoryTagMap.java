package com.example.productlistingdemo.framework;

import com.example.productlistingdemo.model.ItemCategory;
import com.example.productlistingdemo.model.ProductTag;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MockCategoryTagMap {

    // Sample "table" data
    // These should filled by a repository call
    private final List<ProductTag> genderTags = List.of(
            new ProductTag("Unisex"),
            new ProductTag("Male"),
            new ProductTag("Female")
    );

    private final List<ProductTag> designerTags = List.of(
            new ProductTag("Nike"),
            new ProductTag("Gucci"),
            new ProductTag("Zara")
    );

    private final List<ProductTag> brandTags = List.of(
            new ProductTag("Premium"),
            new ProductTag("Casual"),
            new ProductTag("Budget")
    );

    // By using a LinkedHashMap we can control the order that the Category buttons appear while also able to make predefined templates when you build a Listing
    public Map<ItemCategory, List<ProductTag>> buildCategoryTagsMap() {
        Map<ItemCategory, List<ProductTag>> map = new LinkedHashMap<>();
        map.put(new ItemCategory("Gender"), genderTags);
        map.put(new ItemCategory("Designer"), designerTags);
        map.put(new ItemCategory("Brand"), brandTags);
        return map;
    }


}
