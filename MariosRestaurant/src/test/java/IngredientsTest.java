import models.Ingredient;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class IngredientsTest {

    Ingredient ingredient;

    @Before

    public void  before(){

ingredient = new Ingredient("Passatta");
    }

@Test

    public void canGetName(){
        assertEquals("Passatta",ingredient.getName());

    }
}
