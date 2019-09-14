import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (request, response) -> { //request for route happens at this location
            Map<String, Object> model = new HashMap<String, Object>(); // new model is made to store information
            return new ModelAndView(model, "home.hbs"); // assemble individual pieces and render
        }, new HandlebarsTemplateEngine()); //

        //post: process new post form
//        post("/adding", (request, response) -> { //URL to make new post on POST route
//            Map<String, Object> model = new HashMap<>();
//            String content = request.queryParams("content");
//            Hero newHero = new Hero(content);
//            model.put("name", newHero);
//            return new ModelAndView(model, "addhero.hbs");
//        }, new HandlebarsTemplateEngine());

        //get: show all posts
//        get("/", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            ArrayList<Hero> posts = Hero.getAll();
//            model.put("posts", posts);

//        get("/greeting_card", (request, response) -> {
//            Map<String, Object> model = new HashMap<String, Object>();
//            String recipient = request.queryParams("recipient");
//            String sender = request.queryParams("sender");
//            model.put("recipient", recipient);
//            model.put("sender", sender);
//            return new ModelAndView(model, "greeting_card.hbs");
//        }, new HandlebarsTemplateEngine());
    }
}