package models;

import interfaces.Client;
import interfaces.MenuItem;

import java.util.ArrayList;

public class Restaurant {
    private String name;
    private double income;
    private Menu menu;
    private Kitchen kitchen;
    private int maxcapacity;
    private ArrayList<Table> sittings;

    public Restaurant(String name, double income, int maxcapacity){
        this.name = name;
        this.income = 0;
        this.menu = new Menu();
        this.kitchen = new Kitchen();
        this.maxcapacity= maxcapacity;
        this.sittings = new ArrayList();

    }


    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public double getIncome() {
        return this.income;
    }

    public void setIncome(double newIncome) {
        this.income = newIncome;
    }

    public int getCapacity() {
        return this.maxcapacity;
    }

    public void setCapacity(int newCapacity) {
        this.maxcapacity = newCapacity;
    }

    public int countTables() {
        return this.sittings.size();
    }

    public void addTables(Table table) {
        this.sittings.add(table);
    }

    public void removeTable(Table table) {
        this.sittings.remove(table);
    }

    public boolean findtable(Table table) {
        return this.sittings.contains(table);
    }


    public int countClientsOnTables() {
        int totalclients=0;
        for(Table table: sittings){
            totalclients +=table.countClients();
        }
        return totalclients;
    }

        public void sitClient(Client client, Table table) {
        if(this.sittings.contains(table)&& (countClientsOnTables()< maxcapacity)){
            table.addClient(client);
        }
    }

    public int countItemsOnMenu() {
        return this.menu.dishCount();
    }

    public void addItemToMenu(MenuItem item) {
        this.menu.addDish(item);
    }

    public void removeItemFromMenu(MenuItem item) {
        this.menu.removeItem(item);
    }

    public boolean menuHasItem(MenuItem item) {
        return this.menu.menuHas(item);
    }

    public void collectPayment(Table table) {
        this.income +=table.getTotalBill();
        table.collectPayment();
    }

    public void clearTable(Table table) {
        if(this.sittings.contains(table)){
             collectPayment(table);
             table.clearTable();
        }
    }


    public int countItemsOnKitchen() {
        return this.kitchen.countStock();
    }

    public void addItemToKitchenStock(Ingredient ingredient) {
        this.kitchen.addItemToStock(ingredient);
    }

    public void removeItemFromKitchenStock(Ingredient ingredient) {
        this.kitchen.removeItemFromStock(ingredient);
    }

    public boolean KitchenStockHasItem(Ingredient ingredient) {
        return this.kitchen.lookForStockItem(ingredient);
    }

    public double calculateCostOfStock() {
        return this.kitchen.getTotalCosts();
    }


    public double calculateProfit() {
        double profit = this.income - kitchen.getTotalCosts();
        return profit;
    }

    public Menu showMenu(){
        return this.menu;
    }


}
