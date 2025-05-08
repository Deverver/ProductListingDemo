package com.example.productlistingdemo.controller;


import com.example.productlistingdemo.model.ProductListing;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ProductController {

    private final List<ProductListing> allProducts = List.of(
            new ProductListing("Men's Running Shoes", "male", "Nike", "premium"),
            new ProductListing("Women's Heels", "female", "Zara", "budget"),
            new ProductListing("Unisex Hoodie", "unisex", "Gucci", "casual"),
            new ProductListing("Men's Jeans", "male", "Zara", "budget"),
            new ProductListing("Women's Sport Leggings", "female", "Nike", "casual"),
            new ProductListing("Men's Leather Jacket", "male", "Gucci", "premium"),
            new ProductListing("Women's Summer Dress", "female", "Zara", "casual"),
            new ProductListing("Unisex Baseball Cap", "unisex", "Nike", "budget"),
            new ProductListing("Men's Formal Shoes", "male", "Gucci", "premium"),
            new ProductListing("Women's Handbag", "female", "Gucci", "premium"),
            new ProductListing("Men's T-Shirt", "male", "Nike", "casual"),
            new ProductListing("Women's Winter Coat", "female", "Zara", "premium"),
            new ProductListing("Unisex Sneakers", "unisex", "Nike", "casual"),
            new ProductListing("Men's Swim Shorts", "male", "Zara", "budget"),
            new ProductListing("Women's Sandals", "female", "Zara", "budget"),
            new ProductListing("Men's Suit Blazer", "male", "Gucci", "premium"),
            new ProductListing("Women's Sunglasses", "female", "Gucci", "premium"),
            new ProductListing("Unisex Backpack", "unisex", "Nike", "casual"),
            new ProductListing("Women's Yoga Pants", "female", "Nike", "casual"),
            new ProductListing("Men's Hiking Boots", "male", "Nike", "premium")
    );


    @GetMapping("/")
    public String home(Model model) {
        return "redirect:/products";
    }


    @GetMapping("/products")
    public String getProducts(
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
        return "products";
    }
}
