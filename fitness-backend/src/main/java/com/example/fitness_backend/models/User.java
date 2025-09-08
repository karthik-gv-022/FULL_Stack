package com.example.fitness_backend.models;

public class User {
    private final Long id;
    private final String name;

    // constructor
    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // getters
    public Long getId() { return id; }
    public String getName() { return name; }
}
