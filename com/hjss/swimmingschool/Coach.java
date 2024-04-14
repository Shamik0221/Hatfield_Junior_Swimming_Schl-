package com.hjss.swimmingschool;
import java.util.ArrayList;

public class Coach  implements java.io.Serializable {

    // Data Variable for the class
    private static int sequence = 20001;
    private int id;
    private String name;
    private String gender;
    private int age;
    private String phone;
    private int yearOfExperience;
    private ArrayList<Review> listReviews;

    public Coach(String name, String gender, int age, String phone,int yearOfExperience) {
        this.id =  sequence++;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.yearOfExperience = yearOfExperience;
        this.listReviews = new ArrayList<Review>();
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

    public void addReview(Review r) {
        listReviews.add(r);
    }
    
    @Override
    public String toString() {
        return "Name: " + name + ", Gender: " + gender + ", Age: " + age + ", Phone: " + phone + ", Experience: " + yearOfExperience + " years";
    }
    

    public void printInfo() {
        System.out.println("\nCoach Id       : " + id);
        System.out.println("Coach Name     : " + name);
        System.out.println("Coach Gender   : " + gender);
        System.out.println("Coach Age      : " + age);
        System.out.println("Coach Phone    : " + phone);
        System.out.println("Coach Exp      : " + yearOfExperience);
        System.out.println("Reviews: ");
        int index = 0;
        for (index=0; index < listReviews.size(); index++) {
            listReviews.get(index).printInfo();
            System.out.println("");
        }
        System.out.println("\n");
    }

}
