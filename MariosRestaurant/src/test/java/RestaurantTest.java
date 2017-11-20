import models.Patron;
import models.Restaurant;
import models.Table;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RestaurantTest {
    Restaurant restaurant;
    Table table1;
    Table table2;
    Table table3;

    Patron patron1;
    Patron patron2;


    @Before

    public void before(){
        restaurant = new Restaurant("Mamma's", 0, 20 );
        table1= new Table();
        table2= new Table();
        table3= new Table();
        patron1 = new Patron();
        patron2 = new Patron();

    }

    @Test

    public void canGetName(){
        assertEquals("Mamma's", restaurant.getName());
    }

    @Test
    public void canSetName(){
        restaurant.setName("Mamma tua!");
        String actual = restaurant.getName();
        assertEquals("Mamma tua!", actual);
    }

    @Test

    public void canGetincome(){
        assertEquals(0, restaurant.getIncome(),0.01);
    }

    @Test
    public void canSetIncome(){
        restaurant.setIncome(100.0);
        double actual = restaurant.getIncome();
        assertEquals(100.0, actual, 0.01);
    }

    @Test

    public void canGetMaxCapacity(){
        assertEquals(20, restaurant.getCapacity());
    }

    @Test
    public void canSetMaxCapacity(){
        restaurant.setCapacity(40);
        int actual = restaurant.getCapacity();
        assertEquals(40, actual);
    }


    @Test

    public void canCountSittings(){
        int actual = restaurant.countTables();
        assertEquals(0, actual);
    }


    @Test

    public void canAddTablesToSittings(){
        restaurant.addTables(table1);
        restaurant.addTables(table2);
        restaurant.addTables(table3);
        int actual = restaurant.countTables();
        assertEquals(3, actual);

    }

    @Test

    public void canRemoveTableFromSittings(){
        restaurant.addTables(table1);
        restaurant.addTables(table2);
        restaurant.addTables(table3);
        restaurant.removeTable(table2);
        int actual= restaurant.countTables();
        assertEquals(2, actual);
    }

    @Test

    public void canFindTableinSittings(){
        restaurant.addTables(table1);
        restaurant.addTables(table2);
        restaurant.addTables(table3);
        boolean actual= restaurant.findtable(table2);
        assertTrue(actual);

    }
    @Test

    public void cannotFindTableinSittings(){
        restaurant.addTables(table1);
        restaurant.addTables(table2);
        restaurant.addTables(table3);
        restaurant.removeTable(table2);
        boolean actual= restaurant.findtable(table2);
        assertFalse(actual);

    }

    @Test

    public void canAddClientToSpecificTable(){
        restaurant.addTables(table1);
        restaurant.addTables(table2);
        int actual = restaurant.countTables();
        assertEquals(2,actual);

        restaurant.sitClient(patron1,table1);

        int actual1 = table1.countClients();
        assertEquals(1,actual1);

        int actual2 = table2.countClients();
        assertEquals(0,actual2);
    }


    @Test

    public void canCountClientsOnsittings(){
        restaurant.addTables(table1);
        restaurant.addTables(table2);
        restaurant.addTables(table3);
        int actual = restaurant.countTables();
        assertEquals(3,actual);

        restaurant.sitClient(patron1,table1);
        restaurant.sitClient(patron2,table2);
        int actual1 = restaurant.countClientsOnTables();
        assertEquals(2, actual1);
    }

//    @Test
//
//    public void cannotAddClientToSpecificTableDueTOMaxCapacity(){
//        restaurant.setCapacity(2);
//        restaurant.addTables(table1);
//        restaurant.addTables(table2);
//        int actual = restaurant.countTables();
//        assertEquals(2,actual);
//
//        restaurant.sitClient(patron1,table1);
//
//        int actual1 = table1.countClients();
//        assertEquals(1,actual1);
//
//        restaurant.sitClient(patron2, table1);
//
//        int actual2 = table.countClients();
//        assertEquals(0,actual2);
//    }
}
