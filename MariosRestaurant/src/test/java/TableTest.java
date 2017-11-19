import models.Dish;
import models.Menu;
import models.Patron;
import models.Table;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TableTest {

    Patron patron1;
    Patron patron2;
    Patron patron3;
    Table table;
    Menu menu;
    Dish dish1;
    Dish dish2;
    Dish dish3;


    @Before

    public void before(){

        table = new Table();
        patron1 = new Patron();
        patron2= new Patron();
        menu= new Menu();
        dish1= new Dish("soup",3.0);
        dish2 = new Dish( "drumsticks", 4.5);
        dish3 = new Dish("chips", 3.75);

    }

    @Test
    public void tableStartsEmpty(){
        assertEquals(0, table.countClients());
    }


    @Test

    public void canAddClientToTable(){
        table.addClient(patron1);
        int actual = table.countClients();
        assertEquals(1, actual);
    }

    @Test
    public void canRemoveClientFromTable(){
        table.addClient(patron1);
        table.addClient(patron2);
        int actual= table.countClients();
        assertEquals(2, actual);
        table.removeClient(patron1);
        int actual1= table.countClients();
        assertEquals(1, actual1);
    }

    @Test
    public void canCalculateTotalOfTable(){
        table.addClient(patron1);
        table.addClient(patron2);

        int actual = table.countClients();
         assertEquals(2, actual);

         menu.addDish(dish1);
         menu.addDish(dish2);
         menu.addDish(dish3);


         patron1.makeOrder(menu, dish1);
         patron2.makeOrder(menu, dish2);
         patron2.makeOrder(menu, dish3);

         double actual2= table.getTotalBill();
         assertEquals(11.25, actual2,0.01);


    }

    @Test

    public void totalForTableIsSplit(){
        table.addClient(patron1);
        table.addClient(patron2);
        menu.addDish(dish1);
        menu.addDish(dish2);
        menu.addDish(dish3);
        patron1.makeOrder(menu, dish1);
        patron2.makeOrder(menu, dish2);
        patron2.makeOrder(menu, dish3);
        table.SplitTotalEqually();
         double actual =patron2.getBill();
         assertEquals(5.625,actual,0.01);
         double actual2 = patron1.getBill();
        assertEquals(5.625,actual2,0.01);



    }

}
