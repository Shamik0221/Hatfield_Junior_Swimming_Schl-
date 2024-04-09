package com.hjss.swimmingschool;
import java.util.ArrayList;
import java.util.Arrays;


public class SessionManager {

    private ArrayList<Session> listOfSessions ;
    private ArrayList<Coach> listOfCoaches;
    private ArrayList<Learner> listofLearners;

    private String dayChoice;

    public SessionManager(){
        listOfSessions  = new ArrayList<Session>();
        listOfCoaches  = new ArrayList<Coach>();
        listofLearners  = new ArrayList<Learner>();
    }
    public ArrayList<TimeSlot> generateSlots() {
        ArrayList<String> days = new ArrayList<String>(Arrays.asList("Monday","Wednesday","Friday","Saturday"));
        ArrayList<String> times = new ArrayList<String>(Arrays.asList("2","3","4","5","6"));
        ArrayList<TimeSlot> slots = new ArrayList<TimeSlot>();
        for( String day : days) {
            for( String time : times ) {
                if ((day == "Monday" || day == "Wednesday" || day == "Friday" ) && ( time != "2" && time != "3")) {
                    TimeSlot t = new TimeSlot(day,time,1);
                    slots.add(t);
                }
                else if ((day == "Saturday")  && ( time == "2" || time == "3")) {
                    TimeSlot t = new TimeSlot(day,time,1);
                    slots.add(t);
                }
            }
        }
        return slots;

    }
    
    public boolean isValidSlot(String day, String time, int weekNumber ) {
        TimeSlot temp = new TimeSlot(day,time,weekNumber);
        ArrayList<TimeSlot> validTimeSlots = generateSlots();
        for(TimeSlot t : validTimeSlots) {
            if ((t.getDay() == temp.getDay()) && ( t.getTime() == temp.getTime())) {
                return true;
            }
        }
        return false;
    }


    public void registerLearner() {

    }

    public void registerCoach() {

    }

    public void bookSession() {

    }

    public void cancelSession() {

    }

    public void changeSession() {

    }

    public void writeReview(){

    }

    
}
