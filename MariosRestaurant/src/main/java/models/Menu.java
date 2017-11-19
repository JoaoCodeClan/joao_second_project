package models;

import interfaces.MenuItem;

import java.util.ArrayList;

public class Menu {
    private ArrayList<MenuItem> menu;


    public Menu(){
        this.menu= new ArrayList();

    }


    public int dishCount() {
        return this.menu.size();
    }

    public void addDish(MenuItem dish) {
        this.menu.add(dish);
    }

    public boolean menuHas(MenuItem dish) {
        return this.menu.contains(dish);
    }
}
