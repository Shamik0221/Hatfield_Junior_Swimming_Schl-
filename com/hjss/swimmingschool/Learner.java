package com.hjss.swimmingschool;
import java.util.ArrayList;


public class Learner  implements java.io.Serializable {

    private static int sequence = 10001;
    private int id;
    private String name;
    private String gender;
    private int age;
    private String phone;
    private String emergencyContact;
    private int grade;
    private ArrayList<Session> sessionCompleted;
    private ArrayList<Session> sessionCancelled;
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
        
        sessionCompleted = new ArrayList<Session>();
        sessionCancelled = new ArrayList<Session>();
        sessionBooked = new ArrayList<Session>();
    }

    // Setters Methods 
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

    // Getter Methods 
    public int getId()   {
        return this.id;
    }
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

    public int getNumberBooking(){
        return sessionBooked.size();
    }
    
    public boolean isSessionExists(Session s) {
        boolean status = false;
        for(Session t: sessionBooked) {
            if (t.getId() == s.getId()) {
                status = true;
                break;
            }
        }
        return status;
    }

    public void bookSession(Session s){
        if (isSessionExists(s) == false) {
            sessionBooked.add(s);
            System.out.println("Learner :  Session Booked Successfully!");
        }
        else {
            System.out.println("Learner: (Error) Session already exists in Booked Session!");
        }
    }
    
    public void removeSession(Session s){
        if (isSessionExists(s) == true) {
            sessionBooked.remove(s);
            System.out.println("Learner :  Session Removed Successfully!");
        }
        else{
            System.out.println("Learner: (Error) can't find Session in Booked Session!");
        }
    }

    public void cancelSession(Session s){
        if (isSessionExists(s) == true) {
            sessionBooked.remove(s);
            sessionCancelled.add(s);
            System.out.println("Learner :  Session Cancelled Successfully!");

        }
        else {
            System.out.println("Learner: (Error) can't find Session in Booked Session!");
        }
    }

    public void updateSession(Session s) {
        if (isSessionExists(s) == true) {
            sessionBooked.remove(s);
            sessionCompleted.add(s); 

            // update the grade of the student
            if (s.getGrade() >  grade) {
                grade = s.getGrade();
            }
            System.out.println("Learner :  Session Updated Successfully!");
        
        }
        else {
            System.out.println("Learner: (Error) can't find Session in Booked Session!");
        }
    }
   
    @Override
    public String toString() {
        return "Name:" + name + ", Gender:" + gender + ", Age: " + age + ", Phone: " + phone + " , Emergency Contact: " + emergencyContact + " , Grade Level: " + grade ;
    }
    
    public void printCompletedSession() {
        for(int index=0; index < sessionCompleted.size(); index++) {
            System.out.println(sessionCompleted.get(index));
        }
    }
    
    public void printInfo(int month) {
        System.out.println('\n');
        System.out.println("Learner Id       : " + id);
        System.out.println("Learner Name     : " + name);
        System.out.println("Learner Gender   : " + gender);
        System.out.println("Learner Age      : " + age);
        System.out.println("Learner Phone    : " + phone);
        System.out.println("Learner Emergency Contact Phone: " + emergencyContact);
        System.out.println("Learner Grade    : " + grade);
        System.out.println("Completed Session: " + sessionCompleted.size() );
        for(int index = 0;index < sessionCompleted.size(); index++) {
            if ( (int)(sessionCompleted.get(index).getWeek()/4.3454) ==  month-1 ){  
                System.out.println(sessionCompleted.get(index));
                System.out.println("");
            }
        }
        System.out.println("Cancelled Session: " + sessionCancelled.size() );
        for(int index = 0;index < sessionCancelled.size(); index++) {
            if ( (int)(sessionCancelled.get(index).getWeek()/4.3454) ==  month-1 ){  
                System.out.println(sessionCancelled.get(index));
                System.out.println("");
            }
        }
        System.out.println("Booked Session: " +  sessionBooked.size() );
        for(int index = 0;index < sessionBooked.size(); index++) {
            if ( (int)(sessionBooked.get(index).getWeek()/4.3454) ==  month-1 ){  
                System.out.println(sessionBooked.get(index));
                System.out.println("");
            }
        }
        System.out.println('\n');
        
    }
}

