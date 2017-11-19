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

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

    public int numberIngredients() {
        return this.ingredients.size();
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    public boolean containsIngredient(Ingredient ingredient) {
         return this.ingredients.contains(ingredient);
    }

    public void removeIngredient(Ingredient ingredient) {
        this.ingredients.remove(ingredient);
    }
}
