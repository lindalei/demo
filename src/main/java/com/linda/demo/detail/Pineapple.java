package com.linda.demo.detail;

import java.io.Serializable;

public class Pineapple extends Fruit implements Serializable  {
    private static final long serialVersionUID = 86784357209116847L; //保证序列化后类做了改动，还是能反序列化成功
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    private String color;
    private int weight;
    private String shape1;

    public Pineapple(String color, Integer weight) {
        this.color = color;
        this.weight = weight;
    }
    public Pineapple(String color) {
        this.color = color;
    }

}
