package com.example.dto;

import java.io.Serializable;


public class PersonaDTO implements Serializable {

    private String name;
    private String lastName;
    private String date;

    public PersonaDTO(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public PersonaDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String toString(){
        return name+" "+lastName+" "+date;
    }


}
