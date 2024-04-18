package com.hjss.swimmingschool;

import java.util.Arrays;
import java.util.ArrayList;

public class Session implements java.io.Serializable{

    private static int sequence = 30001;
    private static int maxLearner = 4;
    private int id;
    private int gradeLevel;
    private TimeSlot timeslot;
    private Coach coach;
    private int numberLearners;

    private ArrayList<Learner> listOfLearners;

    // Constructor of the class
    public Session(TimeSlot timeslot, Coach c, int gradeLevel) {
        this.id = sequence++;
        this.timeslot = timeslot;
        this.coach = c;
        this.gradeLevel = gradeLevel;
        this.numberLearners = 0;
        this.listOfLearners = new ArrayList<Learner>();
    }

    // Getter Methods 
    public int getId() { 
        return this.id; 
    }
    
    public int getGrade() {
        return this.gradeLevel;
    }
    
    public String getDay() {
        return this.timeslot.getDay();
    }

    public String getTime(){
        return this.timeslot.getTime();
    }

    public int getWeek() {
        return this.timeslot.getWeek();
    }

    public  Coach getCoach(){
        return this.coach;
    }
    
    public int getNumberLearners() {
        return numberLearners;
    }

    public Learner getLearner(int index) {
        return this.listOfLearners.get(index);
    }

    public boolean isLearnerExists(Learner l) {
        boolean status = false;
        for(Learner t: listOfLearners) {
            if (t.getId()  == l.getId()) {
                status = true;
                break;
            }
        }
        return status;
    }

    // Adding Learners into the session
    public boolean addLearner(Learner l){
        boolean status = false;
        if ((numberLearners <= maxLearner)) {
            if ((l.getGrade() == gradeLevel -1) || (l.getGrade() == gradeLevel))  {
                listOfLearners.add(l);
                numberLearners++;
                status = true;
                System.out.println("Session : Learner added Successfully!");
            }
            else{
                System.out.println("Session: (Error) Not a valid Grade to register this Session!");
            }
        }
        else {
            System.out.println("Session: (Error) Maximum number of Learner in the Booked Session!");
        }
        return status;
    }

    // Adding Learners into the session
    public boolean removeLearner(Learner l){
        boolean status = false;
        int index;
        if (isLearnerExists(l)) {
            for(index=0; index < listOfLearners.size(); index++){
                if (l.getId() == listOfLearners.get(index).getId()) {
                    listOfLearners.remove(l);
                    numberLearners--;
                    status = true;
                    break;
                }
            }
        }
        return status;
    }


    @Override
    public String toString() {
        String msg =  "Week: " + timeslot.getWeek() +   "\nDay: " + timeslot.getDay() + "\nTime:" + timeslot.getTime() + "\nGrade Level: " + gradeLevel + "\nCoachName: " + coach.getName() + "\nNumber of Learner:" +
                numberLearners + "\n";
        msg += "Learner Name: ";
        for(Learner l: listOfLearners ){
            msg +=  "(" + l.getName() +  "," + l.getGrade() + ") ";
        }
        msg += "\n";
        return msg;
    }

    public void printInfo() {
        System.out.println("Session Week       : " + timeslot.getWeek());
        System.out.println("Session Day        : " + timeslot.getDay());
        System.out.println("Session Time       : " + timeslot.getTime());
        System.out.println("Session Grade Level: " + gradeLevel);
        System.out.println("Session Coach Name : " + coach.getName());
        System.out.println("Number of Learners : " + numberLearners);
        for(Learner l: listOfLearners ){
            System.out.println("Learner Name: " + l.getName() + " Rating: " + l.getGrade() );
        }
        System.out.println("\n");
    }
}
