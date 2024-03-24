package com.hjss.swimmingschool;

import java.util.UUID;

public class Session {

    public UUID id;

    private String day;
    private String timeslot;
    private String coachName;

    private Review sessionReview;

    public Session(String day, String timeslot, String coachName) {
        this.id =  new UUID();
        this.day = day;
        this.timeslot = timeslot;
        this.coachName = coachName;
    }

    public void updateSession() {


    }
}
