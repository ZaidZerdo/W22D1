package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Planet;
import play.*;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.*;

import views.html.*;

import java.util.ArrayList;
import java.util.List;

public class Application extends Controller {

    private static List<Planet> planetList = new ArrayList<>();

    static {
        planetList.add(new Planet(1L, "Mercury", "At night it can be a few hundred degrees below zero."));
        planetList.add(new Planet(2L, "Venus", "Has extreme temperatures, volcanoes and earthquakes."));
        planetList.add(new Planet(3L, "Earth", "The only planet that has Bitcamp."));
        planetList.add(new Planet(4L, "Mars", "Will be ours one day."));
        planetList.add(new Planet(5L, "Jupiter", "Big brother"));
        planetList.add(new Planet(6L, "Saturn", "Gotta love those rings."));
        planetList.add(new Planet(7L, "Uranus", "Only its name is interesting."));
        planetList.add(new Planet(8L, "Neptune", "The last planet of the SS."));
        planetList.add(new Planet(9L, "Alpha Centauri Bb", "Closest exoplanet"));
        planetList.add(new Planet(10L, "Fomalhaut b", "First to be observed."));
    }

    public Result index() {
        return ok(index.render(planetList.subList(0, 4)));
    }

    public Result getPlanetList() {
        DynamicForm form = Form.form().bindFromRequest();

        int page = 1;
        try {
            page = Integer.parseInt(form.data().get("page"));
        } catch (NumberFormatException ex) {
            Logger.error("Could not parse input.");
            return badRequest();
        }

        int startIndex = (page - 1) * 4;
        int endIndex = startIndex + 4;

        if (endIndex >= planetList.size()) {
            endIndex = planetList.size();
        }

        List<Planet> wantedList = planetList.subList(startIndex, endIndex);

        JsonNode object = Json.toJson(wantedList);

        return ok(object);
    }

}
