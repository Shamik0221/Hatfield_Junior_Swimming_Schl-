package com.hjss.swimmingschool;

import java.util.UUID;

public class Coach {
    private UUID id;
    private String name;
    private String gender;
    private int age;
    private String phone;
    private int yearOfExperience;


    public Coach(String name, String gender, int age, String phone,int yearOfExperience) {
        this.id =  new UUID();
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.yearOfExperience = yearOfExperience;
    }
}
