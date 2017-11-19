import models.Dish;
import models.Ingredient;
import models.Menu;
import models.Patron;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PatronTest {

    Patron patron;
    Menu menu;
    Dish dish1;
    Dish dish2;
    Ingredient ingredient1;
    Ingredient ingredient2;

    @Before

    public void before(){


        patron= new Patron();
        menu = new Menu();
        dish1= new Dish("soup",3.0);
        dish2 = new Dish( "drumsticks", 4.5);
        ingredient1 = new Ingredient("Passatta");
        ingredient2 = new Ingredient("egg");
    }


    @Test

    public void canGetBillValueAndStartsAtZero(){
        double actual= patron.getBill();
        assertEquals(0,actual, 0.01 );
    }

    @Test
    public void canSetBill(){
        patron.setBill(20.0);
        double actual = patron.getBill();
        assertEquals(20, actual, 0.01);
    }

    @Test

    public void patronOrderStartsEmpty(){
        int actual = patron.itemsOnOrder();
        assertEquals(0, actual);
    }

    @Test
    public void patronCanAddItemsToOrder(){
        menu.addDish(dish1);
        menu.addDish(dish2);

        patron.makeOrder(menu,dish2);
        int actual= patron.itemsOnOrder();
        assertEquals(1, actual);

    }

    @Test
    public void patronCannotOrderItem(){

        menu.addDish(dish1);
        patron.makeOrder(menu,dish2);
        int actual= patron.itemsOnOrder();
        assertEquals(0, actual);

    }
}
