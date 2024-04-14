package com.hjss.swimmingschool;

import java.util.Arrays;
import java.util.ArrayList;


public class Session implements java.io.Serializable{

    private static int sequence = 30001;
    private static int maxLearner = 4;

    private int id;
    private int gradeLevel;
    private TimeSlot timeslot;
    private String coachName;
    private int numberLearners;

    private ArrayList<Review> listofReviews;
    private ArrayList<Learner> listOfLearners;

    // Constructor of the class
    public Session(TimeSlot timeslot, String coachName, int gradeLevel) {
        this.id = sequence++;
        this.timeslot = timeslot;
        this.coachName = coachName;
        this.gradeLevel = gradeLevel;
        this.numberLearners = 0;
        this.listOfLearners = new ArrayList<Learner>();
    }

    // only coach name can be change as session is fixed
    public void setCoach(String coach){
        this.coachName = coach;
    }

    // Getter Methods for Session
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

    public String getCoach(){
        return this.coachName;
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
        if ((numberLearners <= maxLearner) && ((l.getGrade() == gradeLevel -1) || (l.getGrade() == gradeLevel)))  {
            status = true;
            l.bookSession(this);
            listOfLearners.add(l);
            numberLearners++;
        }
        return status;
    }

    // Adding Learners into the session
    public boolean removeLearner(Learner l){
        boolean status = false;
        if (isLearnerExists(l)) {
            int index = 0;
            for(;index < listOfLearners.size(); index++){
                if ( l.getId() == listOfLearners.get(index).getId() )
                    break;
            }
            l.cancelSession(this);
            listOfLearners.remove(l);
            numberLearners--;
            status = true;
        }
        return status;
    }


    public int getNumberLearners() {
        return numberLearners;
    }
    
    @Override
    public String toString() {
        String msg =  "Week: " + timeslot.getWeek() +   "\nDay: " + timeslot.getDay() + "\nTime:" + timeslot.getTime() + "\nGrade Level: " + gradeLevel + "\nCoachName: " + coachName + "\nNumber of Learner:" +
                numberLearners + "\n";
        msg += "Learner Name: ";
        for(Learner l: listOfLearners ){
            msg +=  "(" + l.getName() +  "," + l.getGrade() + ") ";
        }
        msg += "\n";
        return msg;
    }

    public void printInfo() {
        System.out.println("Session Id         : " + id);
        System.out.println("Session Day        : " + timeslot.getDay());
        System.out.println("Session Time       : " + timeslot.getTime());
        System.out.println("Session Week       : " + timeslot.getWeek());
        System.out.println("Session Coach Name : " + coachName);
        System.out.println("Number of Learners : " + numberLearners);
        for(Learner l: listOfLearners ){
            System.out.println("Learner Name: " + l.getName() + " Rating: " + l.getGrade() );
        }
        System.out.println("\n");
    }
}
