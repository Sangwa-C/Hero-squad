import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");


        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> posts = Hero.getAll();
            model.put("posts", posts);
            return new ModelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());


        //route that makes new post
        post("/posts/new", (request, response) -> {
            Map<String, Object> modelf = new HashMap<>();
            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String power = request.queryParams("power");
            String weakness = request.queryParams("weakness");

            Hero newHero = new Hero(name,age,power,weakness);

            modelf.put("name", newHero.getName());
            modelf.put("age", newHero.getAge());
            modelf.put("power", newHero.getPower());
            modelf.put("weakness", newHero.getWeakness());
            System.out.println(name);
            return new ModelAndView(modelf, "hero.hbs");
        }, new HandlebarsTemplateEngine());

        get("/posts/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "newpost-form.hbs");
        }, new HandlebarsTemplateEngine());


        get("/squad-form", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Squad> posts = Squad.getThemAll();
            model.put("sname", posts);
            return new ModelAndView(model, "squad-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/squad-results", (request, response) -> {
            Map<String, Object> modelq = new HashMap<>();
            String sname = request.queryParams("sname");
            String cause= request.queryParams("cause");
            int size = Integer.parseInt(request.queryParams("size"));

            Squad newSquad = new Squad(sname,cause,size);

            modelq.put("sname",newSquad.getSname());
            modelq.put("cause",newSquad.getCause());
            modelq.put("size",newSquad.getSize());
            return new ModelAndView(modelq, "squad-results.hbs");
        }, new HandlebarsTemplateEngine());

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "newpost-form.hbs");
        }, new HandlebarsTemplateEngine());


    }
}

