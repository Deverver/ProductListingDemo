package com.example.productlistingdemo.controller;


import com.example.productlistingdemo.framework.MockCategoryTagMap;
import com.example.productlistingdemo.model.ItemCategory;
import com.example.productlistingdemo.model.ProductListing;
import com.example.productlistingdemo.model.TagFilterForm;
import com.example.productlistingdemo.model.ProductTag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class ProductController {
    MockCategoryTagMap mock = new MockCategoryTagMap();
    Map<ItemCategory, List<ProductTag>> categoryTagsMap = mock.buildCategoryTagsMap();


    private final List<ProductListing> allProducts = List.of(
            new ProductListing("Men's Running Shoes", "Male", "Nike", "Premium"),
            new ProductListing("Women's Heels", "Female", "Zara", "Budget"),
            new ProductListing("Unisex Hoodie", "Unisex", "Gucci", "Casual"),
            new ProductListing("Men's Jeans", "Male", "Zara", "Budget"),
            new ProductListing("Women's Sport Leggings", "Female", "Nike", "Casual"),
            new ProductListing("Men's Leather Jacket", "Male", "Gucci", "Premium"),
            new ProductListing("Women's Summer Dress", "Female", "Zara", "Casual"),
            new ProductListing("Unisex Baseball Cap", "Unisex", "Nike", "Budget"),
            new ProductListing("Men's Formal Shoes", "Male", "Gucci", "Premium"),
            new ProductListing("Women's Handbag", "Female", "Gucci", "Premium"),
            new ProductListing("Men's T-Shirt", "Male", "Nike", "Casual"),
            new ProductListing("Women's Winter Coat", "Female", "Zara", "Premium"),
            new ProductListing("Unisex Sneakers", "Unisex", "Nike", "Casual"),
            new ProductListing("Men's Swim Shorts", "Male", "Zara", "Budget"),
            new ProductListing("Women's Sandals", "Female", "Zara", "Budget"),
            new ProductListing("Men's Suit Blazer", "Male", "Gucci", "Premium"),
            new ProductListing("Women's Sunglasses", "Female", "Gucci", "Premium"),
            new ProductListing("Unisex Backpack", "Unisex", "Nike", "Casual"),
            new ProductListing("Women's Yoga Pants", "Female", "Nike", "Casual"),
            new ProductListing("Men's Hiking Boots", "Male", "Nike", "Premium")
    );


    @GetMapping("/")
    public String home(Model model) {
        return "redirect:/updatedForm";
    }

    @GetMapping("/updatedForm")
    public String showForm(
            @ModelAttribute TagFilterForm filterForm,
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) String designer,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String condition,
            Model model
    ) {

        TagFilterForm tagFilterForm = new TagFilterForm();
        model.addAttribute("tagFilterForm", tagFilterForm);
        model.addAttribute("categoryTagsMap", categoryTagsMap);


        List<ProductListing> filtered = allProducts.stream()
                .filter(p -> gender == null || gender.isEmpty() || p.getGenderTag().equalsIgnoreCase(gender))
                .filter(p -> designer == null || designer.isEmpty() || p.getDesigner().equalsIgnoreCase(designer))
                .filter(p -> brand == null || brand.isEmpty() || p.getBrand().equalsIgnoreCase(brand))
                .filter(p -> condition == null || condition.isEmpty() || p.getBrand().equalsIgnoreCase(condition))
                .collect(Collectors.toList());


        model.addAttribute("products", filtered);
        model.addAttribute("selectedGender", gender);
        model.addAttribute("selectedDesigner", designer);
        model.addAttribute("selectedBrand", brand);
        model.addAttribute("selectedCondition", condition);

        return "updatedDropdownFilter";
    }



    
    @GetMapping("/dropdownForm")
    public String dropdownSearch(
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) String designer,
            @RequestParam(required = false) String brand,
            Model model
    ) {

        List<ProductListing> filtered = allProducts.stream()
                .filter(p -> gender == null || gender.isEmpty() || p.getGenderTag().equalsIgnoreCase(gender))
                .filter(p -> designer == null || designer.isEmpty() || p.getDesigner().equalsIgnoreCase(designer))
                .filter(p -> brand == null || brand.isEmpty() || p.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());

        model.addAttribute("products", filtered);
        model.addAttribute("selectedGender", gender);
        model.addAttribute("selectedDesigner", designer);
        model.addAttribute("selectedBrand", brand);

        return "dropdownSearch";
    }


}