package com.hjss.swimmingschool;

public class Learner {
    private UUID Id;
    private String name;
    private String gender;
    private int age;
    private String phone;
    private String emergencyContact;
    private int grade;

    public Learner(String name, String gender, int age, String phone, String emergencyContact, int grade) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.emergencyContact = emergencyContact;
        this.grade = grade;

    }


}
