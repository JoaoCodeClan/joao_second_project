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


}
