import models.Dish;
import models.Ingredient;
import models.Menu;
import models.Patron;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void canCheckIfPatronOrderedItem(){
        menu.addDish(dish1);
        menu.addDish(dish2);

        patron.makeOrder(menu,dish2);
        int actual= patron.itemsOnOrder();
        assertEquals(1, actual);
        boolean actual1 = patron.orderContains(dish2);
        assertTrue(actual1);
    }

    @Test
    public void canCheckIfPatronHasNotOrderedItem(){
        menu.addDish(dish1);
        menu.addDish(dish2);

        patron.makeOrder(menu,dish2);
        int actual= patron.itemsOnOrder();
        assertEquals(1, actual);
        boolean actual1 = patron.orderContains(dish1);
        assertFalse(actual1);
    }

    @Test
    public void patronCanAskToRemoveIngredientFromDish(){
        dish1.addIngredient(ingredient1);
        dish1.addIngredient(ingredient2);
        menu.addDish(dish1);
        menu.addDish(dish2);

        int actual = menu.dishCount();
        assertEquals(2, actual);
        int actual1= dish1.numberIngredients();
        assertEquals(2, actual1);
        patron.costumiseItem(menu,dish1, ingredient2);
        int actual2= dish1.numberIngredients();
        assertEquals(1, actual2);
        boolean actual3 = dish1.containsIngredient(ingredient2);
        assertFalse(actual3);

    }

    @Test
    public void patronCanAskToRemoveIngredientFromItemButItemDoesntContainIt(){

        dish1.addIngredient(ingredient2);
        menu.addDish(dish1);
        menu.addDish(dish2);

        int actual = menu.dishCount();
        assertEquals(2, actual);
        int actual1= dish1.numberIngredients();
        assertEquals(1, actual1);
        patron.costumiseItem(menu,dish1, ingredient1);
        int actual2= dish1.numberIngredients();
        assertEquals(1, actual2);
        boolean actual3 = dish1.containsIngredient(ingredient2);
        assertTrue(actual3);

    }

    @Test

    public void canGetexpense(){

        menu.addDish(dish1);
        menu.addDish(dish2);

        patron.makeOrder(menu,dish2);
        patron.makeOrder(menu,dish1);

        double actual = patron.getExpense();
        assertEquals(7.5,actual,0.01);

    }


}
