import models.Ingredient;
import models.Kitchen;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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


}
