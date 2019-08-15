package com.teamnaughty.food.myspringcrud.entity;

public class Gender {
    private String value;

    public Gender(){
        value = "nam";
    }
    public Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
