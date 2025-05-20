package com.example.productlistingdemo.model;

public class productTag {
    private int id;
    private String tagValue;


    public productTag(String tagValue) {
        this.tagValue = tagValue;
    }


    public String getTagValue() {
        return tagValue;
    }

    public void setTagValue(String tagValue) {
        this.tagValue = tagValue;
    }

}
