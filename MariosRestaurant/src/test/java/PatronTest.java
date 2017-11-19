import models.Dish;
import models.Ingredient;
import models.Menu;
import models.Patron;
import org.junit.Before;

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
    
}
