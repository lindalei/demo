package com.linda.demo.detail;

public class Apple extends  Fruit {
    private String color;
    private int weight;

    public Apple(Integer weight) {
        this.weight = weight;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
