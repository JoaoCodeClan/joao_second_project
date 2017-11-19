package models;

import java.util.ArrayList;

public class Dish {
    private String name;
    private double price;
    private ArrayList<Ingredient> ingredients;

    public Dish(String name, double price){
        this.name= name;
        this.price = price;
        this.ingredients = new ArrayList(); 
    }
}
