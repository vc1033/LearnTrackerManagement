package com.airtribe.LearnTrack.entity;

import com.airtribe.LearnTrack.exception.InvalidInputException;

public abstract class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    protected Person(int id, String firstName, String lastName , String email) {

            this.id = id;
            this.email = email;
            this.lastName = lastName;
            this.firstName = firstName;
    }

    protected Person(int id, String firstName, String lastName) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public int getId(){
        return id;
    }
    protected String getFirstName() {
        return firstName;
    }

    protected String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public abstract String getDisplayName();
}
