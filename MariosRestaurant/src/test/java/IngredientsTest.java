import models.Ingredient;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class IngredientsTest {

    Ingredient ingredient;

    @Before

    public void  before(){

ingredient = new Ingredient("Passatta", 2.0, 3);
    }

    @Test

    public void canGetName(){
        assertEquals("Passatta",ingredient.getName());

    }
    @Test

    public void canSetNewName(){
        ingredient.setName("CreamSauce");
        String actual = ingredient.getName();
        assertEquals("CreamSauce", actual);
    }

    @Test

    public void canGetPrice(){
        assertEquals(2.0,ingredient.getPrice(), 0.01);

    }
    @Test

    public void canSetPrice(){
        ingredient.setPrice(4.0);
       double actual = ingredient.getPrice();
        assertEquals(4.0, actual, 0.01);
    }
    @Test

    public void canGetAmount(){
       assertEquals(3, ingredient.getAmount());

    }
    @Test

    public void canSetAmount(){
        ingredient.setAmount(5);
      int actual = ingredient.getAmount();
        assertEquals(5, actual);
    }
}
