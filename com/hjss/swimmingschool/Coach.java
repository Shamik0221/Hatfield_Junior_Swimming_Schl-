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

    // Setters Method of the Coach Class
    
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

    public void setYearOfExperience(int years) {
        this.yearOfExperience = years;
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

    public int getYearOfExperience() {
        return this.yearOfExperience ; 
    }

    
    @Override
    public String toString() {
        return name + ", " + age + "," + gender + ",(" + phone + ") " + yearOfExperience;
    }
    

    public void printInfo() {
        System.out.println("Coach Id       : " + id);
        System.out.println("Coach Name     : " + name);
        System.out.println("Coach Gender   : " + gender);
        System.out.println("Coach Age      : " + age);
        System.out.println("Coach Phone    : " + phone);
        System.out.println("Coach Exp      : " + yearOfExperience);
    }
}
