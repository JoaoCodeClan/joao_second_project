import database.IngredientRepo;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");

        IngredientRepo repo = new IngredientRepo();
//        Ingredient ingredient = new Ingredient("salsa", 1.0, 3);
//        repo.save(ingredient);

        repo.updateIngredientAmount(1, 50);
        repo.showAll();

    }
}
