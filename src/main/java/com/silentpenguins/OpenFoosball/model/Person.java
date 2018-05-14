package com.silentpenguins.OpenFoosball.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "person")
public class Person /*implements Serializable*/ {

    @Id
    private String name;

    public Person(String name) {
        this.name = name;
    }
    protected Person() {}

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
