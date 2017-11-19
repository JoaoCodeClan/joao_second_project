package models;

public class Ingredient {
    private String name;
//    private double price; to be added if wanted to create a way of manger to calculate the profits for restuarant;


    public Ingredient(String name){
        this.name= name;
    }


    public String getName() {
        return this.name;
    }
}
