package com.hjss.swimmingschool;

import java.util.ArrayList;

public class Session {
    private static int sequence = 30001;

    private static int maxLearner = 4;

    private int id;
    private String day;
    private String timeslot;
    private String coachName;
    private Review sessionReview;

    private int currentLearner;

    private ArrayList<Learner> listOfLearners ;

    public Session(String day, String timeslot, String coachName) {
        this.id = sequence++; 
        this.day = day;
        this.timeslot = timeslot;
        this.coachName = coachName;
        this.currentLearner = 0;
        this.listOfLearners = new ArrayList<Learner>();
    }

    public void updateSession() {

    }

    public void printInfo() {
        System.out.println("Session Id: " + id);
    }
}
