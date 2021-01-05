package com.americanairlines.myfourthapplication.model;


import java.io.Serializable;

public class Pizza implements Serializable {

    private String pizzaflavor;
    private double pizzaPrice;

    private int calories;
    private String ingredients;
    private String imageUrl;

    public Pizza(String pizzaflavor, double pizzaPrice, int calories, String ingredients, String imageUrl) {
        this.pizzaflavor = pizzaflavor;
        this.pizzaPrice = pizzaPrice;
        this.calories = calories;
        this.ingredients = ingredients;
        this.imageUrl = imageUrl;
    }

    public String getPizzaflavor() {
        return pizzaflavor;
    }

    public void setPizzaflavor(String pizzaflavor) {
        this.pizzaflavor = pizzaflavor;
    }

    public double getPizzaPrice() {
        return pizzaPrice;
    }

    public void setPizzaPrice(double pizzaPrice) {
        this.pizzaPrice = pizzaPrice;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
