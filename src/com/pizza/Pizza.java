package com.pizza;

import java.util.Arrays;

public class Pizza {


    private String[] ingredients;
    private double price;


    Pizza(String[] ingredients,double price) {
        this.ingredients = ingredients;
        this.price = price;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }


    @Override
    public String toString() {
        return "Pizza ingredients: " + Arrays.toString(ingredients) +
                ", price = " + price;
    }

}