package models;

import java.util.ArrayList;

public class Kitchen {
    private ArrayList<Ingredient>stock;

    public Kitchen(){
        this.stock= new ArrayList();
    }

    public int countStock() {
        return this.stock.size();
    }
}
