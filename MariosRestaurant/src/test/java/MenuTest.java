import models.Dish;
import models.Menu;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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

    public void canAddDishToMenu(){
        menu.addDish(dish1);
        int actual = menu.dishCount();
        assertEquals(1, actual);

}
    @Test

    public void canAddMultipleDishesToMenu(){
        menu.addDish(dish1);
        menu.addDish(dish2);
        menu.addDish(dish3);
        int actual = menu.dishCount();
        assertEquals(3, actual);

    }
}
