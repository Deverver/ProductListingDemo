package com.example.productlistingdemo.model;

public class ProductListing {
    private String name;
    private String genderTag;
    private String designer;
    private String brand;

    public ProductListing(String name, String genderTag, String designer, String brand) {
        this.name = name;
        this.genderTag = genderTag;
        this.designer = designer;
        this.brand = brand;
    }

    public String getName() { return name; }
    public String getGenderTag() { return genderTag; }
    public String getDesigner() { return designer; }
    public String getBrand() { return brand; }
}
