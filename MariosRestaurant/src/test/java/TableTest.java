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


    @Before

    public void before(){

        table = new Table();
        patron1 = new Patron();
        patron2= new Patron();

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
    public


}
