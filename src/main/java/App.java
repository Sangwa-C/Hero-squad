
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import models.Hero;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");


        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> posts = Hero.getAll();
            model.put("name", posts);
            return new ModelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());

        //route that makes new post
        post("/posts/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String power = request.queryParams("power");
            String weakness = request.queryParams("weakness");
            Hero newHero = new Hero(name,age,power,weakness);
            model.put("name", newHero);
            return new ModelAndView(model, "hero.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show new post form
        get("/posts/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "newpost-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squad-form", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> posts = Hero.getAll();
            model.put("name", posts);
            return new ModelAndView(model, "squad-form.hbs");
        }, new HandlebarsTemplateEngine());
    }
}

