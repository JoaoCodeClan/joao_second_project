
import spark.ModelAndView;

import java.util.HashMap;

import static spark.Spark.get;
import static spark.Spark.staticFileLocation;

public class Main {

    public static void main(String[] args) {

        staticFileLocation("/public");
        String layout = "templates/layout.vtl";

        get("/", (request, response) -> {
            HashMap<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/homepage.vtl" );
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());


        get("/menu", (request, response) -> {
            HashMap<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/menu.vtl" );
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());


        get("/restaurant", (request, response) -> {
            HashMap<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/restaurant.vtl" );
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/stock", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("template", "templates/stock.vtl" );
        return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

}
}





