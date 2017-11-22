import database.IngredientRepo;
import models.Ingredient;
import spark.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;

import static spark.Spark.get;
import static spark.Spark.staticFileLocation;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        staticFileLocation("/public");

        HashMap<String, Object> model = new HashMap<>();

        IngredientRepo repo = new IngredientRepo();

        ArrayList<Ingredient> allIngs = repo.showAll();

        model.put("all",allIngs);

        get("/ingredients", (req, res) -> new ModelAndView(model, "templates/hello.vtl")
                , new VelocityTemplateEngine());


    }
}
