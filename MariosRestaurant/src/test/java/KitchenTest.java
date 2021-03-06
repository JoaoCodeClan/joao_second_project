import models.Dish;
import models.Ingredient;
import models.Kitchen;
import models.Menu;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class KitchenTest {

    Kitchen kitchen;
    Ingredient ingredient1;
    Ingredient ingredient2;
    Ingredient ingredient3;
    Ingredient ingredient4;
    Dish dish1;
    Dish dish2;
    Menu menu;

    @Before


    public void before(){

        kitchen = new Kitchen();
        ingredient1 = new Ingredient("tomato sauce", 3.0,5);
        ingredient2 = new Ingredient("spaghetti",3.0, 5);
        ingredient3 = new Ingredient("chicken",3.0, 5);
        ingredient4 = new Ingredient("Mozarella", 3.0, 5);
        dish1= new Dish("dish1",10.0);
        dish2= new Dish("dish2", 12.0);
        menu= new Menu();

    }

    @Test

    public void kitchenStartsEmpty(){
        assertEquals(0, kitchen.countStock());
    }

    @Test
    public void canAddItemsToStock(){
        kitchen.addItemToStock(ingredient1);
        int actual= kitchen.countStock();
        assertEquals(1, actual);
    }

    @Test

    public void canLookForItemInStock(){
        kitchen.addItemToStock(ingredient1);
        kitchen.addItemToStock(ingredient2);
       boolean actual =  kitchen.lookForStockItem(ingredient1);
       assertTrue(actual);
    }

    @Test

    public void canRemoveItemfromStock(){
        kitchen.addItemToStock(ingredient1);
        kitchen.addItemToStock(ingredient2);

        int actual=kitchen.countStock();
        assertEquals(2, actual);

        kitchen.removeItemFromStock(ingredient2);
         int actual1 = kitchen.countStock();
        assertEquals(1, actual1);

        boolean actual2= kitchen.lookForStockItem(ingredient2);
        assertFalse(actual2);

    }


    @Test

    public void canCalculateTotalCostOfIngredients(){
        kitchen.addItemToStock(ingredient1);
        kitchen.addItemToStock(ingredient2);
        kitchen.addItemToStock(ingredient3);
        kitchen.addItemToStock(ingredient4);
        double actual =kitchen.getTotalCosts();
        assertEquals(12.0, actual, 0.01);

    }




}
