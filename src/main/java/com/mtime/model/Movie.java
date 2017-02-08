package com.mtime.model;

/**
 * @author yixiong.wyx
 */
public class Movie {

    private String name;

    private String time;

    private String country;

    private String type;

    private String category;

    private String resource;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", country='" + country + '\'' +
                ", type='" + type + '\'' +
                ", category='" + category + '\'' +
                ", resource='" + resource + '\'' +
                '}';
    }
}
