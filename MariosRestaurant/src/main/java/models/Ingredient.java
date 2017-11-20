package models;

public class Ingredient {
    private String name;
    private double price;
    private int amount;


    public Ingredient(String name, double price, int amount){
        this.name= name;
        this.price = price;
        this.amount =amount;
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
}
