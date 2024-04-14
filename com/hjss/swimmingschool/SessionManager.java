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
        ArrayList<String> times = new ArrayList<String>(Arrays.asList("2-3pm","3-4pm","4-5pm","5-6pm","6-7pm"));
        ArrayList<TimeSlot> slots = new ArrayList<TimeSlot>();
        for(int weekNumber=1; weekNumber<=52 ; weekNumber++ ) {
            for( String day : days) {
                for( String time : times ) {
                    if ((day == "Monday" || day == "Wednesday" || day == "Friday" ) && ( time != "2-3pm" && time != "3-4pm")) {
                        TimeSlot t = new TimeSlot(day,time,weekNumber);
                        slots.add(t);
                    }
                    else if ((day == "Saturday")  && ( time == "2-3pm" || time == "3-4pm")) {
                        TimeSlot t = new TimeSlot(day,time,weekNumber);
                        slots.add(t);
                    }
                }
            }
        }
        return slots;

    }

    // findCoach
    public Coach findCoach(String coachName) {
        Coach c = null;
        int index = 0;
        for(; index< listCoaches.size(); index++) {
            if (listCoaches.get(index).getName().equals(coachName)) {
                c = listCoaches.get(index);
                break;
            }
        }
        return c;
    }

    // findSession function check the TimeSlot which is valid
    public Session findSession(String day, String time, int weekNumber ) {
        TimeSlot temp = new TimeSlot(day,time,weekNumber);
        Session s = null;
        int index = 0;
        for(; index< listSessions.size(); index++) {
            if (listSessions.get(index).getDay().equals(temp.getDay()) && listSessions.get(index).getTime().equals(temp.getTime()) && listSessions.get(index).getWeek() == temp.getWeek()) {
                s = listSessions.get(index);
                break;
            }
        }
        return s;
    }

    // isValidSlot function check the TimeSlot which is valid
    public boolean isValidSlot(String day, String time, int weekNumber ) {
        TimeSlot temp = new TimeSlot(day,time,weekNumber);
        ArrayList<TimeSlot> validTimeSlots = generateSlots();
        for(TimeSlot t : validTimeSlots) {
            if (t.getDay().equals(temp.getDay()) && t.getTime().equals(temp.getTime()) && t.getWeek() == temp.getWeek()) {
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

    // Find Learner name in the registered Learner
    public boolean isLearnerRegister(String name) {
        int index = 0;
        for(; index<listLearners.size(); index++){
            if (listLearners.get(index).getName().equals(name) ){
                return true;
            }
        }
        return false;
    }

    public Learner findLearner(String name) {
        int index = 0;
        Learner l = null;
        for(; index<listLearners.size(); index++){
            if (listLearners.get(index).getName().equals(name)){
                l = listLearners.get(index);
                break;
            }
        }
        return l;
    }

    public boolean removeLearner(Session s, Learner l) {
        int index = 0;
        boolean status = false;
        for(; index<listSessions.size(); index++){
            if (listSessions.get(index).isLearnerExists(l)){
                listSessions.get(index).removeLearner(l);
                return true;
            }
        }
        return status;
    }

    public void displayUpComingSessionByDay(String day) {
        System.out.println("\nSession Available: ");
        for(Session s : listSessions) {
            if (s.getNumberLearners() < 4 && s.getDay().equals(day)){
                System.out.println(s);
            }
        }
    }

    public void displayUpComingSessionByGrade(int gradeLevel){
        System.out.println("\nSession Available: ");
        for(Session s : listSessions) {
            if (s.getNumberLearners() < 4 && s.getGrade() == gradeLevel){
                System.out.println(s);
            }
        }
    }
    public void displayUpComingSessionByInstructor(String coachName) {
        System.out.println("\nSession Available: ");
        for(Session s : listSessions) {
            if (s.getNumberLearners() < 4 && s.getCoach().equals(coachName)){
                System.out.println(s);
            }
        }

    }
    public void displayLearnerBookedSession(Learner l){
        int index = 0;
        for(index=0; index < listSessions.size(); index++ ){
            if (listSessions.get(index).isLearnerExists(l)){
                System.out.println("Session["+index+"]:\n" + listSessions.get(index));
            }
        }
    }

    public void displayUpComingSession() {
        System.out.println("\nSession Available: ");
        for(Session s : listSessions) {
            if (s.getNumberLearners() < 4){
                System.out.println(s);
            }
        }
    }

    public void displaySessionReport() {
        System.out.println("\n");
        int index = 0;
        System.out.println("Session Booked: ");
        for(; index < listSessions.size(); index++) {
            listSessions.get(index).printInfo();

        }
    }

    public void displayLearnerReport(int month) {
        System.out.println("\n");
        int index = 0;
        for(; index < listLearners.size(); index++) {
            listLearners.get(index).printInfo(month);
        }
    }

    public void displayCoachReport(int month) {
        System.out.println("\n");
        int index = 0;
        for(; index < listCoaches.size(); index++) {
            listCoaches.get(index).printInfo(month);
        }
    }


    // printing the report and number of Learners 
    public void displayMonthlyReport(int month) {
        System.out.println("********************************************************************************8");
        System.out.println("Coach Registered: " + getNumberCoaches());
        displayCoachReport(month);
        System.out.println("Learner Registered: "+ getNumberLearners());
        displayLearnerReport(month);
        System.out.println("********************************************************************************8");

    }


        
    // Booking a session in Session by adding a learner 
    public boolean bookSession(Session s, Learner l) {
        return s.addLearner(l);
    }

    public boolean cancelSession(Session s, Learner l) {
        return s.removeLearner(l);
    }

    public boolean  changeSession(Session os, Session ns, Learner l) {
        boolean status = os.removeLearner(l);
        if (status) {
            status = ns.addLearner(l);
            if (status)
                return true;
            else
                return false;
        }
        return status;
    }

    public void registerLearner(Learner l) {
        listLearners.add(l);
    }

    public void registerCoach(Coach c) {
        listCoaches.add(c);
    }

}
