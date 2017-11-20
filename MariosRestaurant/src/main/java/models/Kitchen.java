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

    public void addItemToStock(Ingredient ingredient) {
        this.stock.add(ingredient);
    }

    public boolean lookForStockItem(Ingredient ingredient) {
        return this.stock.contains(ingredient);
    }

    public void removeItemFromStock(Ingredient ingredient) {
        this.stock.remove(ingredient);
    }
}
