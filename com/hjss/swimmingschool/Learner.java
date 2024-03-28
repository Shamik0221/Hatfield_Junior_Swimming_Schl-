package com.hjss.swimmingschool;
import java.util.ArrayList;

public class Learner {
    private static int sequence = 10001;
    private int id;
    private String name;
    private String gender;
    private int age;
    private String phone;
    private String emergencyContact;
    private int grade;
    private ArrayList<Session> sessionFinished;
    private ArrayList<Session> sessionBooked;

    public Learner(String name, String gender, int age, String phone, String emergencyContact, int grade) {
        this.id = sequence++;
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
