package com.example.productlistingdemo.framework;

import com.example.productlistingdemo.model.ItemCategory;
import com.example.productlistingdemo.model.ProductTag;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockCategoryTagMap {

    // Sample "table" data
    // These should filled by a repository call
    // Ideally these should contain id as well
    private final List<ProductTag> genderTags = List.of(
            new ProductTag("Unisex"),
            new ProductTag("Male"),
            new ProductTag("Female"),
              new ProductTag("TestCategory01"),
          new ProductTag("TestCategory02"),
          new ProductTag("TestCategory03"),
          new ProductTag("TestCategory04"),
          new ProductTag("TestCategory04")
    );

    private final List<ProductTag> designerTags = List.of(
            new ProductTag("Nike"),
            new ProductTag("Gucci"),
            new ProductTag("Zara"),
            new ProductTag("TestCategory06"),
            new ProductTag("TestCategory07"),
            new ProductTag("TestCategory08")
    );

    private final List<ProductTag> brandTags = List.of(
            new ProductTag("Premium"),
            new ProductTag("Casual"),
            new ProductTag("Budget"),
            new ProductTag("TestCategory09"),
            new ProductTag("TestCategory10"),
            new ProductTag("TestCategory11")
    );

    public Map<ItemCategory, List<ProductTag>> buildCategoryTagsMap() {
        Map<ItemCategory, List<ProductTag>> map = new HashMap<>();
        map.put(new ItemCategory("Gender"), genderTags);
        map.put(new ItemCategory("Designer"), designerTags);
        map.put(new ItemCategory("Brand"), brandTags);
        return map;
    }


}
