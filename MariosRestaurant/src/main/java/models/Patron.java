package models;

import interfaces.MenuItem;

import java.util.ArrayList;

public class Patron {
    private double bill;
    private ArrayList<MenuItem> order;

    public Patron(){
        this.bill = 0;
        this.order = new ArrayList();

    }
}
