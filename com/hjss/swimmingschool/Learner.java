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

    // Constructor
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

    // Setters Method of the Learner Class

    public void setName(String newName)   {
        this.name = newName;
    }

    public void setGender(String newGender) {
        this.gender = newGender;
    }

    public void setAge(int newAge) {
        this.age = newAge;
    }

    public void setPhone(String newPhone) {
        this.phone = newPhone;
    }

    public void setEmergencyContact(String  newPhone) {
        this.emergencyContact = newPhone;
    }

    public void setGrade(int  newGrade) {
        this.grade = newGrade;
    }

    // Getter Methods of the Coach Class
    public String getName()   {
        return this.name;
    }

    public String getGender( ) {
        return this.gender ;
    }

    public int  getAge( ) {
        return this.age;
    }

    public String  getPhone() {
        return this.phone ;
    }

    public String getEmergencyContact() {
        return this.emergencyContact;
    }

    public int getGrade() {
        return this.grade;
    }


    public void bookSession(){

    }

    public void updateSession(){

    }


}
