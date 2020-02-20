package com.example.dto;

import android.widget.DatePicker;

import java.io.Serializable;
import java.util.Date;

public class PersonaDTO implements Serializable {

    private String name;
    private String lastName;
    private DatePicker date;

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

    public DatePicker getDate() {
        return date;
    }

    public void setDate(DatePicker date) {
        this.date = date;
    }

    public String toString(){
        return name+" "+lastName+" "+date;
    }
}
