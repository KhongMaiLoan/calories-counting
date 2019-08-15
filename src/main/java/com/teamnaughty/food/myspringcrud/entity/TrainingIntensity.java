package com.teamnaughty.food.myspringcrud.entity;

public class TrainingIntensity {

    public Integer id;
    public String value;

    public TrainingIntensity(){
        id=0;
        value="Ít vận động hoặc không tập thể dục";
    }
    public TrainingIntensity(Integer id, String value) {
        this.id = id;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
