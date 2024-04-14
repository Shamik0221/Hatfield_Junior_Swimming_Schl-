package com.hjss.swimmingschool;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


public class Coach  implements java.io.Serializable {

    // Data Variable for the class
    private static int sequence = 20001;
    private int id;
    private String name;
    private String gender;
    private int age;
    private String phone;
    private int yearOfExperience;
    private Map<Integer, ArrayList<Review> > mapReviews;

    public Coach(String name, String gender, int age, String phone,int yearOfExperience) {
        this.id =  sequence++;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.yearOfExperience = yearOfExperience;
        this.mapReviews = new HashMap<>();
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

    public void addReview(int month,Review r) {
        ArrayList<Review> rList = mapReviews.get(month);
        if (rList == null)
            rList = new ArrayList<>();
        rList.add(r);
        mapReviews.put(month,rList); 
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Gender: " + gender + ", Age: " + age + ", Phone: " + phone + ", Experience: " + yearOfExperience + " years";
    }


    public void printInfo(int month) {
        System.out.println("\nCoach Id     : " + id);
        System.out.println("Coach Name     : " + name);
        System.out.println("Coach Gender   : " + gender);
        System.out.println("Coach Age      : " + age);
        System.out.println("Coach Phone    : " + phone);
        System.out.println("Coach Exp      : " + yearOfExperience);
        System.out.println("Reviews: ");
        float totalRating = 0;
        int avgRating = 0;
        int numberRating  = 0;
        for(Integer key: mapReviews.keySet()) {
            if (key == month) {
                ArrayList <Review> rList = mapReviews.get(key);
                for (Review r : rList) {
                    totalRating += r.getRating();
                    numberRating += 1;
                    r.printInfo();
                }
                System.out.println("");
                avgRating = (int) (totalRating / numberRating);
                System.out.print("Coach Avg. Rating : " +avgRating + " ");
                if (avgRating == 1)
                    System.out.println("Very Dissatified!");
                else if (avgRating == 2)
                    System.out.println("Dissatified!");
                else if (avgRating == 3)
                    System.out.println("Ok!");
                else if (avgRating == 4)
                    System.out.println("Satified!");
                else if (avgRating == 5)
                    System.out.println("Very Satified!");
                System.out.println("\n");
            }
        }
    }

}
