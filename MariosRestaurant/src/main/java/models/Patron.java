package models;

import interfaces.Client;
import interfaces.MenuItem;

import java.util.ArrayList;

public class Patron implements Client {
    private double bill;
    private ArrayList<MenuItem> order;

    public Patron(){
        this.bill = 0;
        this.order = new ArrayList();

    }


    public double getBill() {
        return this.bill;
    }



    public void setBill(double newBill) {
        this.bill = newBill;
    }

    public int itemsOnOrder() {
         return this.order.size();
    }


    public void makeOrder(Menu menu, MenuItem item){
        if(menu.menuHas(item)){
            this.order.add(item);
        }

    }

    public boolean orderContains(MenuItem item) {
        return this.order.contains(item);
    }

    public void costumiseItem(Menu menu, MenuItem item, Ingredient ingredient) {
        if (menu.menuHas(item)){
            item.removeIngredient(ingredient);
        }
    }
}
