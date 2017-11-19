import models.Dish;
import models.Menu;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MenuTest {

    Menu menu;
    Dish dish1;
    Dish dish2;
    Dish dish3;

    @Before

    public void before(){

        menu= new Menu();
        dish1= new Dish("soup",3.0);
        dish2 = new Dish( "drumsticks", 4.5);
        dish3 = new Dish("chips", 3.75);
    }

@Test

    public void menuStartsEmpty(){
        int actual= menu.dishCount();
    assertEquals(0, actual);

}

@Test

    public void canAddItemToMenu(){
        menu.addDish(dish1);
        int actual = menu.dishCount();
        assertEquals(1, actual);

}
    @Test

    public void canAddMultipleItemsToMenu(){
        menu.addDish(dish1);
        menu.addDish(dish2);
        menu.addDish(dish3);
        int actual = menu.dishCount();
        assertEquals(3, actual);

    }



    @Test

    public void canFindItemOnMenu(){
        menu.addDish(dish1);
        menu.addDish(dish2);
        menu.addDish(dish3);
        boolean actual = menu.menuHas(dish2);
        assertTrue(actual);

    }

    @Test

    public void cannotFindItemOnMenu(){
        menu.addDish(dish1);
        menu.addDish(dish2);
        boolean actual = menu.menuHas(dish3);
        assertFalse(actual);
    }


//    @Test

//    public void canRemoveDishFromMenu(){
//        menu.addDish(dish1);
//        menu.addDish(dish2);
//        menu.addDish(dish3);
//        int actual = menu.dishCount();
//        assertEquals(3, actual)
//    }
}
