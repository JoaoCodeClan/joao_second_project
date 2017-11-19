import models.Dish;
import models.Ingredient;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DishTest {
    Dish dish;
    Ingredient ingredient1;
    Ingredient ingredient2;
    Ingredient ingredient3;

    @Before

    public void before(){

        ingredient1 = new Ingredient("spaghetti");
        ingredient2 = new Ingredient("Passatta");
        ingredient3 = new Ingredient("Seafood mix");
        dish = new Dish("Seafood spaghetti", 9.0);
    }

    @Test
    public void canGetDishName(){
        assertEquals("Seafood spaghetti", dish.getName());
    }

    @Test
    public void canSetDishName(){
        dish.setName("mareghetti");
        String actual = dish.getName();
        assertEquals("mareghetti", actual);
    }

    @Test
    public void canGetDishPrice(){
        double actual =dish.getPrice();
        assertEquals(9.0,actual,01);
    }

    @Test
    public void canSetDishPrice(){
        dish.setPrice(10.5);
         double actual= dish.getPrice();
         assertEquals(10.5,actual, 0.01);
    }

    @Test
    public void dishIngredientsStartEmpty(){
        int actual= dish.numberIngredients();
        assertEquals(0, actual);
    }

    @Test

    public void canAddIngredientToIngredientsInDish(){
        dish.addIngredient(ingredient1);
        int actual= dish.numberIngredients();
        assertEquals(1, actual);

    }


    @Test

    public void canAddMultipleIngredientsToDish(){
        dish.addIngredient(ingredient1);
        dish.addIngredient(ingredient2);
        dish.addIngredient(ingredient3);
        int actual= dish.numberIngredients();
        assertEquals(3, actual);
    }

    @Test
    public void canKnowIfIngredientIsOnDish(){
        dish.addIngredient(ingredient1);
        dish.addIngredient(ingredient2);
        dish.addIngredient(ingredient3);
        boolean actual = dish.containsIngredient(ingredient2);
        assertTrue(actual);
    }

    @Test
    public void canKnowIfIngredientIsNotOnDish(){
        dish.addIngredient(ingredient1);
        dish.addIngredient(ingredient3);
        boolean actual = dish.containsIngredient(ingredient2);
        assertTrue(actual);
    }
}
