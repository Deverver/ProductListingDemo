package com.example.productlistingdemo.controller;


import com.example.productlistingdemo.model.ProductListing;
import com.example.productlistingdemo.model.TagFilterForm;
import com.example.productlistingdemo.model.productTag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ProductController {
    /**
     * Genders; All, Unisex, Male, Female
     * Designer; All, Nike, Gucci, Zara
     * Brand; All, Premium, Casual, Budget
     * Submit button to apply filters
     */

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

    private final List<productTag> genderTags = List.of(
            new productTag("Unisex"),
            new productTag("Male"),
            new productTag("Female")
    );

    private final List<productTag> designerTags = List.of(
            new productTag("Nike"),
            new productTag("Gucci"),
            new productTag("Zara")
    );

    private final List<productTag> brandTags = List.of(
            new productTag("Premium"),
            new productTag("Casual"),
            new productTag("Budget")
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


    @GetMapping("/awarehover")
    public String selectBoxTest01(Model model) {
        return "/selectBoxAwareHower";
    }

    @GetMapping("/profile")
    public String profileTest(Model model) {
        return "/profile";
    }


    @GetMapping("/dropdownForm")
    public String dropdownSearch(
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) String designer,
            @RequestParam(required = false) String brand,
            Model model
    ) {
        List<productTag> tagsForGenders = genderTags.stream().toList();
        List<productTag> tagsForDesigners = designerTags.stream().toList();
        List<productTag> tagsForBrands = brandTags.stream().toList();

        model.addAttribute("tagsForGender", tagsForGenders);
        model.addAttribute("tagsForDesigner", tagsForDesigners);
        model.addAttribute("tagsForBrand", tagsForBrands);



        List<ProductListing> filtered = allProducts.stream()
                .filter(p -> gender == null || gender.isEmpty() || p.getGenderTag().equalsIgnoreCase(gender))
                .filter(p -> designer == null || designer.isEmpty() || p.getDesigner().equalsIgnoreCase(designer))
                .filter(p -> brand == null || brand.isEmpty() || p.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());


        model.addAttribute("products", filtered);
        model.addAttribute("selectedGender", gender);
        model.addAttribute("selectedDesigner", designer);
        model.addAttribute("selectedBrand", brand);
        model.addAttribute("selectedTagsForm", new TagFilterForm());
        return "/dropdownSearch";
    }


    @GetMapping("/filter")
    public String filter(
            @ModelAttribute("selectedTagsForm") TagFilterForm tagFilterForm,
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) String designer,
            @RequestParam(required = false) String brand,
            Model model
    ) {
        List<productTag> tagsForGenders = genderTags.stream().toList();
        List<productTag> tagsForDesigners = designerTags.stream().toList();
        List<productTag> tagsForBrands = brandTags.stream().toList();

        model.addAttribute("tagsForGender", tagsForGenders);
        model.addAttribute("tagsForDesigner", tagsForDesigners);
        model.addAttribute("tagsForBrand", tagsForBrands);
        model.addAttribute("filterForm", tagFilterForm);


        List<ProductListing> filtered = allProducts.stream()
                .filter(p -> gender == null || gender.isEmpty() || p.getGenderTag().equalsIgnoreCase(tagFilterForm.getGender()))
                .filter(p -> designer == null || designer.isEmpty() || p.getDesigner().equalsIgnoreCase(tagFilterForm.getDesigner()))
                .filter(p -> brand == null || brand.isEmpty() || p.getBrand().equalsIgnoreCase(tagFilterForm.getBrand()))
                .collect(Collectors.toList());

        model.addAttribute("products", filtered);
        model.addAttribute("selectedGender", gender);
        model.addAttribute("selectedDesigner", designer);
        model.addAttribute("selectedBrand", brand);

        return "dropdownSearch";
    }





}
