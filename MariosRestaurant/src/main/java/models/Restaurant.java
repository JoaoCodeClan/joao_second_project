package models;

import java.util.ArrayList;

public class Restaurant {
    private String name;
    private double income;
    private Menu menu;
    private int maxcapacity;
    private ArrayList<Table> sittings;

    public Restaurant(String name, double income, int maxcapacity){
        this.name = name;
        this.income = 0;
        this.menu = new Menu();
        this.maxcapacity= maxcapacity;
        this.sittings = new ArrayList();

    }


    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }
}
