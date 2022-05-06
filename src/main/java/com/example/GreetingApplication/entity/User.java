package com.example.GreetingApplication.entity;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class User {
    public String firstName;
    public String lastName;


    @Override
    public String toString() {
        String str = (firstName != null) ? firstName + " " : "";
        str += (lastName != null) ? lastName : "";
        return str.trim();

    }
}

