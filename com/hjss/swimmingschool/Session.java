package com.hjss.swimmingschool;

import java.util.ArrayList;

public class Session {
    private static int sequence = 30001;

    private static int maxLearner = 4;

    private int id;
    private String day;
    private String timeslot;
    private String coachName;

    private int numberLearners;

    private ArrayList<Review> listofReviews;
    private ArrayList<Learner> listOfLearners ;


    // Constructor of the class
    public Session(String day, String timeslot, String coachName) {
        this.id = sequence++;
        this.day = day;
        this.timeslot = timeslot;
        this.coachName = coachName;
        this.numberLearners = 0;
        this.listOfLearners = new ArrayList<Learner>();
        this.listofReviews = new ArrayList<Review>();
    }

    // Setter methods for Session Class
    public void setDay(String day) {
        this.day = day;
    }

    public void setTimeSlot(String timeslot){
        this.timeslot = timeslot;
    }

    public void setCoach(string coach){
        this.coachName = coach;
    }

    // Getter Methods for Session
    public String getDay() {
        return this.day;
    }

    public String getTimeSlot(){
        return this.timeslot;
    }

    public String getCoach(){
        return this.coachName;
    }


    // Adding Review into the list
    public void addReview(Review r){
        listofReviews.add(r);
    }

    // Adding Learners into the session
    public boolean addLearner(Learner l) {
        boolean status = false;
        if (numberLearners < maxLearner) {
            listOfLearners.add(l);
            numberLearners++;
            status = true;
        }
        return status;
    }

    @Override
    public String toString() {
        String msg =  "Day: " + day + "\nTimeSlot:" + timeslot + "\nCoachName: " + coachName + "\nNumber of Learner:" +
                numberLearners + "\n";
        for(Review r: listofReviews ){
            msg += "Review: (" + r.getComments() +"," + r.getRating() +  "\n";
        }
        for(Learner l: listOfLearners ){
            msg += "Learner Name: " + l.getName() + "\n";
        }

        return msg;
    }

    public void printInfo() {


        System.out.println("Session Id         : " + id);
        System.out.println("Session Day        : " + day);
        System.out.println("Session Timeslot   : " + timeslot);
        System.out.println("Session Coach Name : " + coachName);
        System.out.println("Number of Learners : " + numberLearners);
        for(Review r: listofReviews ){
            System.out.println("Review: (" + r.getComments() +"," + r.getRating());
        }
        for(Learner l: listOfLearners ){
            System.out.println("Learner Name: " + l.getName());
        }

    }
}
