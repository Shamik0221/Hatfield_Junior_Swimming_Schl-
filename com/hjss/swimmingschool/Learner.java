package com.hjss.swimmingschool;
import java.util.ArrayList;
import java.util.UUID;

public class Learner {
    private UUID Id;
    private String name;
    private String gender;
    private int age;
    private String phone;
    private String emergencyContact;
    private int grade;

    private ArrayList<Session> sessionFinished;

    private ArrayList<Session> sessionBooked;

    public Learner(String name, String gender, int age, String phone, String emergencyContact, int grade) {
        this.id =  new UUID();
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.emergencyContact = emergencyContact;
        this.grade = grade;
        sessionFinished = new ArrayList<Session>();
        sessionBooked = new ArrayList<Session>();
    }

    public void bookSession(){

    }

    public void updateSession(){

    }
}
