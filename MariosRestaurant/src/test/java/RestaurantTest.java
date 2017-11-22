import models.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RestaurantTest {
    Restaurant restaurant;
    Table table1;
    Table table2;
    Table table3;

    Patron patron1;
    Patron patron2;

    Dish dish1;
    Dish dish2;

    Menu menu;

    Kitchen kitchen;


    @Before

    public void before() {
        restaurant = new Restaurant("Mamma's", 0, 20);
        table1 = new Table();
        table2 = new Table();
        table3 = new Table();
        patron1 = new Patron();
        patron2 = new Patron();
        dish1 = new Dish("soup", 3.0);
        dish2 = new Dish("chips", 3.0);
        menu = new Menu();

    }

    @Test

    public void canGetName() {
        assertEquals("Mamma's", restaurant.getName());
    }

    @Test
    public void canSetName() {
        restaurant.setName("Mamma tua!");
        String actual = restaurant.getName();
        assertEquals("Mamma tua!", actual);
    }

    @Test

    public void canGetincome() {
        assertEquals(0, restaurant.getIncome(), 0.01);
    }

    @Test
    public void canSetIncome() {
        restaurant.setIncome(100.0);
        double actual = restaurant.getIncome();
        assertEquals(100.0, actual, 0.01);
    }

    @Test

    public void canGetMaxCapacity() {
        assertEquals(20, restaurant.getCapacity());
    }

    @Test
    public void canSetMaxCapacity() {
        restaurant.setCapacity(40);
        int actual = restaurant.getCapacity();
        assertEquals(40, actual);
    }


    @Test

    public void canCountSittings() {
        int actual = restaurant.countTables();
        assertEquals(0, actual);
    }


    @Test

    public void canAddTablesToSittings() {
        restaurant.addTables(table1);
        restaurant.addTables(table2);
        restaurant.addTables(table3);
        int actual = restaurant.countTables();
        assertEquals(3, actual);

    }

    @Test

    public void canRemoveTableFromSittings() {
        restaurant.addTables(table1);
        restaurant.addTables(table2);
        restaurant.addTables(table3);
        restaurant.removeTable(table2);
        int actual = restaurant.countTables();
        assertEquals(2, actual);
    }

    @Test

    public void canFindTableinSittings() {
        restaurant.addTables(table1);
        restaurant.addTables(table2);
        restaurant.addTables(table3);
        boolean actual = restaurant.findtable(table2);
        assertTrue(actual);

    }

    @Test

    public void cannotFindTableinSittings() {
        restaurant.addTables(table1);
        restaurant.addTables(table2);
        restaurant.addTables(table3);
        restaurant.removeTable(table2);
        boolean actual = restaurant.findtable(table2);
        assertFalse(actual);

    }

    @Test

    public void canAddClientToSpecificTable() {
        restaurant.addTables(table1);
        restaurant.addTables(table2);
        int actual = restaurant.countTables();
        assertEquals(2, actual);

        restaurant.sitClient(patron1, table1);

        int actual1 = table1.countClients();
        assertEquals(1, actual1);

        int actual2 = table2.countClients();
        assertEquals(0, actual2);
    }


    @Test

    public void canCountClientsOnsittings() {
        restaurant.addTables(table1);
        restaurant.addTables(table2);
        restaurant.addTables(table3);
        int actual = restaurant.countTables();
        assertEquals(3, actual);

        restaurant.sitClient(patron1, table1);
        restaurant.sitClient(patron2, table2);
        int actual1 = restaurant.countClientsOnTables();
        assertEquals(2, actual1);
    }

    @Test

    public void cannotAddClientToSpecificTableDueTOMaxCapacity() {
        restaurant.setCapacity(1);
        restaurant.addTables(table1);
        restaurant.addTables(table2);
        int actual = restaurant.countTables();
        assertEquals(2, actual);

        restaurant.sitClient(patron1, table1);

        int actual1 = table1.countClients();
        assertEquals(1, actual1);

        restaurant.sitClient(patron2, table2);

        int actual2 = table2.countClients();
        assertEquals(0, actual2);
    }

    @Test

    public void menuStartsEmpty() {
        int actual = restaurant.countItemsOnMenu();
        assertEquals(0, actual);

    }

    @Test

    public void canAddItemToMenu() {
        restaurant.addItemToMenu(dish1);
        restaurant.addItemToMenu(dish2);
        int actual = restaurant.countItemsOnMenu();
        assertEquals(2, actual);

    }

    @Test

    public void canRemoveItemfromMenu() {
        restaurant.addItemToMenu(dish1);
        restaurant.addItemToMenu(dish2);
        int actual = restaurant.countItemsOnMenu();
        assertEquals(2, actual);
        restaurant.removeItemFromMenu(dish2);
        int actual1 = restaurant.countItemsOnMenu();
        assertEquals(1, actual1);

    }

    @Test

    public void canFindItemOnMenu() {
        restaurant.addItemToMenu(dish1);
        restaurant.addItemToMenu(dish2);
        boolean actual = restaurant.menuHasItem(dish2);
        assertTrue(actual);
    }

    @Test

    public void canCollectPaymentFromTableAndUpdateIncome() {
        restaurant.setCapacity(20);
        restaurant.addTables(table1);
        restaurant.addTables(table2);
        menu.addDish(dish1);
        menu.addDish(dish2);
        int actual = restaurant.countTables();
        assertEquals(2, actual);

        restaurant.sitClient(patron1, table1);

        int actual1 = table1.countClients();
        assertEquals(1, actual1);

        restaurant.sitClient(patron2, table2);

        int actual2 = table2.countClients();
        assertEquals(1, actual2);

        patron1.makeOrder(menu, dish1);

        restaurant.collectPayment(table1);
        double actual3 = restaurant.getIncome();
        assertEquals(3, actual3, 0.01);
        double actual4 = patron1.getBill();
        assertEquals(0, actual4, 0.01);
    }

    @Test
    public void canEmptytable() {
        restaurant.setCapacity(20);
        restaurant.addTables(table1);
        restaurant.addTables(table2);
        restaurant.sitClient(patron1, table1);
        restaurant.sitClient(patron2, table1);
        int actual = table1.countClients();
        assertEquals(2, actual);
        int actual1= table2.countClients();
        assertEquals(0,actual1);
        restaurant.clearTable(table1);
        int actual2 = table1.countClients();
        assertEquals(0, actual2);
    }


    @Test
    public void canGetProfit(){
        restaurant.
    }
}

