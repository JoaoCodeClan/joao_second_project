import models.Menu;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MenuTest {

    Menu menu;


    @Before

    public void before(){

        menu= new Menu();
    }

@Test

    public void menuStartsEmpty(){
        int actual= menu.dishCount();
    assertEquals(0, actual);

}

@Test

    public void canAddDishToMenu(){
        
}

}
