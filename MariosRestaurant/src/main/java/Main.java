import database.IngredientRepo;
import models.Ingredient;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");

        IngredientRepo repo = new IngredientRepo();
        Ingredient ingredient = new Ingredient("salsa", 1.0, 3);
        repo.save(ingredient);
        repo.showAll();

    }
}
