package com.example.itunes.model;

public class Customer {
    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    private Integer id;
    private String firstName;

    public Customer(Integer id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }
}
