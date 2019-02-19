package com.linda.demo.detail;

public class Orange extends Fruit{
    private String color;
    private int weight;

    public Orange(Integer weight) {
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

    public Orange(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
