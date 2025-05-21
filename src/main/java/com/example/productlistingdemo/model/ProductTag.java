package com.example.productlistingdemo.model;

public class ProductTag {

    private int id;
    private String tagValue;

    public ProductTag() {
    }

    public ProductTag(String tagValue) {
        this.tagValue = tagValue;
    }

    public String getTagValue() {
        return tagValue;
    }

    public void setTagValue(String tagValue) {
        this.tagValue = tagValue;
    }

    @Override
    public String toString() {
        return tagValue;
    }

}
