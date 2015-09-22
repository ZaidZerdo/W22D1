package models;

/**
 * Created by Zaid on 9/22/2015.
 */
public class Planet {
    public Long id;
    public String name;
    public String description;

    public Planet(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
