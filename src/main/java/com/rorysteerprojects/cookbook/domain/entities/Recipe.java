package com.rorysteerprojects.cookbook.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Recipe {

    private int id;
    private String name;
    private LocalDate dateLastCooked;

    public Recipe() {
    }

    public Recipe(int id, String name, LocalDate dateLastCooked) {
        this.id = id;
        this.name = name;
        this.dateLastCooked = dateLastCooked;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateLastCooked() {
        return dateLastCooked;
    }

    public void setDateLastCooked(LocalDate dateLastCooked) {
        this.dateLastCooked = dateLastCooked;
    }
}
