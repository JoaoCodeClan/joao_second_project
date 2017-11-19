package interfaces;

import models.Ingredient;

public interface MenuItem {

     double getPrice();
     void removeIngredient(Ingredient ingredient);
}
