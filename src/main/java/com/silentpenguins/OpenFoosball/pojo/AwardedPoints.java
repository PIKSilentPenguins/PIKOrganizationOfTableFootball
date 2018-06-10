package com.silentpenguins.OpenFoosball.pojo;

import java.sql.Blob;

public class AwardedPoints {

    private Long id;
    private Integer points;
    private String name;
    private Blob image;

    public AwardedPoints() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }
}
