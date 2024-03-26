package com.hjss.swimmingschool;

public class Coach {
    private static int sequence = 20001;
    private int id;
    private String name;
    private String gender;
    private int age;
    private String phone;
    private int yearOfExperience;


    public Coach(String name, String gender, int age, String phone,int yearOfExperience) {
        this.id =  sequence++;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.yearOfExperience = yearOfExperience;
    }
}
