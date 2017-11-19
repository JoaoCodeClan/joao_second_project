import models.Patron;
import models.Restaurant;
import models.Table;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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



}
