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
        ingredient1 = new Ingredient("tomato sauce");
        ingredient2 = new Ingredient("spaghetti");
        ingredient3 = new Ingredient("chicken");
        ingredient4 = new Ingredient("Mozarella");

    }

    @Test

    public void kitchenStartsEmpty(){
        assertEquals(0, kitchen.countStock());
    }
}
