package com.hjss.swimmingschool;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;



public class SessionManager {

    private ArrayList<Coach> listOfCoaches;
    private ArrayList<Session> listOfSessions ;
    private ArrayList<Learner> listofLearners;

    private String dayChoice;


    public SessionManager(){
        listOfCoaches  = new ArrayList<Coach>();
        listOfSessions  = new ArrayList<Session>();
        listofLearners  = new ArrayList<Learner>();
    }
    
    public void addCoach(Coach c) {
        listOfCoaches.add(c);
    }
    
    public String getCoachName(int index) {
        return listOfCoaches.get(index).getName();
    }

    public Session getSession(int index) {
        return listOfSessions.get(index);
    }
    
    public int getNumberCoaches() {
        return listOfCoaches.size();
    }
    
    public int getNumberSessions() {
        return listOfSessions.size();
    }
    
    public void printCoachs() {
        for(Coach c : listOfCoaches)
            System.out.println(c);
    }

    public void addSession(Session s) {
        listOfSessions.add(s);
    }
    
    public void printSessions() {
        for(Session s : listOfSessions ) {
            System.out.println(s);
        }
    }
    
    public void addLearner(Learner l) {
        listofLearners.add(l);
    }
    
    public void printLearners() {
        for(Learner l : listofLearners) {
            System.out.println(l);
        }
    }
    
    public boolean bookSession(Session s, Learner l) {
        return s.addLearner(l);
    }

    public ArrayList<TimeSlot> generateSlots() {
        ArrayList<String> days = new ArrayList<String>(Arrays.asList("Monday","Wednesday","Friday","Saturday"));
        ArrayList<String> times = new ArrayList<String>(Arrays.asList("2","3","4","5","6"));
        ArrayList<TimeSlot> slots = new ArrayList<TimeSlot>();
        for(int weekNumber=1; weekNumber<=4 ; weekNumber++ ) {
            for( String day : days) {
                for( String time : times ) {
                    if ((day == "Monday" || day == "Wednesday" || day == "Friday" ) && ( time != "2" && time != "3")) {
                        TimeSlot t = new TimeSlot(day,time,weekNumber);
                        slots.add(t);
                    }
                    else if ((day == "Saturday")  && ( time == "2" || time == "3")) {
                        TimeSlot t = new TimeSlot(day,time,weekNumber);
                        slots.add(t);
                    }
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
