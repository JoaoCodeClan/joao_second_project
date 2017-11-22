package models;

public class Ingredient {
    private String name;
    private double price;
    private int amount;
    private int id;

    public Ingredient(int id, String name, double price, int amount) {
        this.id = id;
        this.name= name;
        this.price = price;
        this.amount =amount;
    }

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

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int newAmount) {
        this.amount = newAmount;
    }

    public int getId(){
        return this.id;
    }
}
