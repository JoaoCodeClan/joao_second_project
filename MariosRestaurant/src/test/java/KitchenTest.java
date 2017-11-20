import models.Ingredient;
import models.Kitchen;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class KitchenTest {

    Kitchen kitchen;
    Ingredient ingredient1;
    Ingredient ingredient2;
    Ingredient ingredient3;
    Ingredient ingredient4;


    @Before


    public void before(){

        kitchen = new Kitchen();
        ingredient1 = new Ingredient("tomato sauce", 3.0,5);
        ingredient2 = new Ingredient("spaghetti",3.0, 5);
        ingredient3 = new Ingredient("chicken",3.0, 5);
        ingredient4 = new Ingredient("Mozarella", 3.0, 5);

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


}
