package com.hjss.swimmingschool;
import java.util.ArrayList;
import java.util.Arrays;



public class SessionManager implements java.io.Serializable {

    private ArrayList<Coach> listCoaches;
    private ArrayList<Session> listSessions ;
    private ArrayList<Learner> listLearners;

    public SessionManager(){
        listCoaches  = new ArrayList<Coach>();
        listSessions  = new ArrayList<Session>();
        listLearners  = new ArrayList<Learner>();
    }
    
    // Returns the Learner, Coach and Session from the list by index
    public Learner  getLearner(int index) {
        return listLearners.get(index);
    }

    public Coach getCoach(int index) {
        return listCoaches.get(index);
    }

    public Session getSession(int index) {
        return listSessions.get(index);
    }
   
    // Getting function which returns the number of members in Coachs, Learners, and Sessions
    public int getNumberLearners() {
        return listLearners.size();
    }
    
    public int getNumberCoaches() {
        return listCoaches.size();
    }
    
    public int getNumberSessions() {
        return listSessions.size();
    }
    
    // Adding Coach, Learner and Session into the respective Lists
    public void addCoach(Coach c) {
        listCoaches.add(c);
    }

    public void addLearner(Learner l) {
        listLearners.add(l);
    }

    public void addSession(Session s) {
        listSessions.add(s);
    }
    
    // generateSlots helper function to generate list of TimeSlot
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
    
    // isValidSlot function check the TimeSlot which is valid
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
    
    // Printing the Coach in the list
    public void printCoachs() {
        int index = 0;
        for(index=0; index < listCoaches.size(); index++ ){
            System.out.println("Coach["+index+"]: " + listCoaches.get(index));
        }
    }

    // Printing the Session in the list
    public void printSessions() {
        int index = 0;
        for(index=0; index < listSessions.size(); index++ ){
            System.out.println("Session["+index+"]:\n" + listSessions.get(index));
        }
    }
    
    // Printing the Learner in the list
    public void printLearners() {
        int index = 0;
        for(index=0; index < listLearners.size(); index++ ){
            System.out.println("Learner["+index+"]: " + listLearners.get(index));
        }
    }
    
    // printing the report and number of Learners 
    public void displayReport() {
        System.out.println("Coach Registered: " + getNumberCoaches());
        System.out.println("******************************************");
        printCoachs();
        System.out.println("******************************************");
        System.out.println("Learner Registered: "+ getNumberLearners());
        System.out.println("******************************************");
        printLearners();
        System.out.println("******************************************");
        System.out.println("Session Booked: "+ + getNumberSessions());
        System.out.println("******************************************");
        printSessions();
        System.out.println("******************************************");

    }
        
    // Booking a session in Session by adding a learner 
    public boolean bookSession(Session s, Learner l) {
        return s.addLearner(l);
    }

    public String inputName(String object) {
        String name = " ";
        System.out.print("Enter the "+ object + ": ");
        return name ;
    }

    public void registerLearner(Learner l) {
        listLearners.add(l);
    }

    public void registerCoach() {

    }

    public void cancelSession() {

    }

    public void changeSession() {

    }

    public void writeReview(){

    }

    public void bookSession() {
    }

}
