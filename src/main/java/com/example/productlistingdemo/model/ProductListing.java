package com.example.productlistingdemo.model;

public class ProductListing {
    private final String name;
    private final String genderTag;
    private final String designer;
    private final String brand;

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

    @Override
    public String toString() {
        return "ProductListing{" +
                "name='" + name + '\'' +
                ", genderTag='" + genderTag + '\'' +
                ", designer='" + designer + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}

