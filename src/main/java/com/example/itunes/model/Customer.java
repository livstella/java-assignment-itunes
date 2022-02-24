package com.example.itunes.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {

    private Integer id;
    private String firstName;
    private String lastName;
    private String country;
    private Integer postalCode;
    private Integer phone;
    private String email;

    public Customer() {}

    public Customer(@JsonProperty("id") Integer id,@JsonProperty("firstName") String firstName,@JsonProperty("lastName") String lastName,@JsonProperty("country") String country,@JsonProperty("postalCode") Integer postalCode,@JsonProperty("phone") Integer phone,@JsonProperty("email") String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.postalCode = postalCode;
        this.phone = phone;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }


    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;

    }
}
