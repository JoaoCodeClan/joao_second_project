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

    
}
