package com.hjss.swimmingschool;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.lang.ClassNotFoundException;
import java.lang.Math;

import java.util.Scanner;  // Import the Scanner class
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Random;


public class Driver {
    
    // Manager for Sessiones, Coaches and Leearners
    private static SessionManager ssm;
    
    //random generators
    private static Random randomGenerator = new Random();

    public static void main(String[] args) throws Exception {

        // creating an object of Scanner Class
        Scanner sc = new Scanner(System.in);

        // Setting welcome msg
        System.out.println("Welcome to the Hatfield Junior Swimming School");

        // setting run to true for running a loop until user exit
        int optionNumber = 1;

        boolean run = true;
        // Runing a loop until user choose to exit

        // temperarory Session variable, Coach and Learner for processing
        Session s,ns;
        Coach c;
        Learner l;
        String name, coachName, day;
        boolean status = false ;
        int lIndex;
        int gradeLevel;
        int choice;
        int weekNumber;
        int monthNumber;
        
        // read database.obj file or read defaultinput.txt file to create sessions, coaches, and Learners
        ssm = readDatabase();

        while (run) {

            // displaying Menu
            displayMenu();

            System.out.print("Enter your options: ");
            optionNumber = sc.nextInt();

            switch(optionNumber) {

                case 1 : l = promptLearner(sc);
                         ssm.registerLearner(l);
                         break;

                case 2 : name = getString(sc, "Enter the Learner's Name: ");
                         if (ssm.isLearnerRegister(name)) {
                             l = ssm.findLearner(name);
                         }
                         else {
                             System.out.println(name + " is not registered in the Learners!");
                             System.out.println("Warning : Perform the Learner Registeration!");
                             break;
                         }
                         System.out.println("For Booking Session choose among three choices:");
                         System.out.println("1. Book the session by Day (Monday, Wednesday, Friday, or Saturday");
                         System.out.println("2. Book the session by grade level 1,2,3,4,5");
                         System.out.println("3. Book the session by instructor wise\n");
                         choice = getInt(sc,"Enter the value between 1 to 3: ",1,3,"Warning: Please enter value between 1 to 3");
                         if (choice == 1) {
                             while(true){
                                 day = getString(sc,"Enter the day (Monday, Wednesday, Friday, or Saturday): ");
                                 if ( day.equals("Monday") || day.equals("Wednesday") || day.equals("Friday") || day.equals("Saturday") == true)
                                     break;
                                 else
                                     System.out.println(day + "not a valid day!");
                             }
                             ssm.displayUpComingSessionByDay(day);
                         }
                         else if (choice == 2) {
                             gradeLevel = getInt(sc, "Enter the grade level (1,2,3,4,5): ",1,5,"Warning: Please enter integer value between 1 to 5");
                             ssm.displayUpComingSessionByGrade(gradeLevel);

                         }else if (choice == 3) {
                             while(true){
                                 coachName = getString(sc,"Enter the Coach's Name: ");
                                 c  = ssm.findCoach(coachName);
                                 if ( c != null)
                                     break;
                                 else
                                     System.out.println(coachName + "not a valid coach Name!");
                             }
                             ssm.displayUpComingSessionByInstructor(coachName);
                         }
                         s = promptAndFindSession(sc);
                         status = ssm.bookSession(s,l);
                         if (status) 
                             System.out.println("Booking is Sucessful!");
                         else
                             System.out.println("Booking is Unsucessful!");

                         break;
                case 3 : name = getString(sc, "Enter the Learner's Name: ");
                         if (ssm.isLearnerRegister(name)) {
                             l = ssm.findLearner(name);
                         }
                         else {
                             System.out.println("Warning: " + name + " is not registered in the Learners!");
                             break;
                         }
                         status = ssm.displayLearnerBookedSession(l);
                         if (status ) {
                             s = promptAndFindSession(sc);
                             status = ssm.cancelSession(s,l);
                             if (status)
                                 System.out.println("Cancellation of booking is Sucessful!");
                             else
                                 System.out.println("Cancellation of booking is Unsucessful!");
                         }
                         else {
                                 System.out.println(l.getName() + ": No booking found for Learner");
                         }
                         break;


                case 4 : name = getString(sc, "Enter the Learner's Name: ");
                         if (ssm.isLearnerRegister(name)) {
                             l = ssm.findLearner(name);
                         }
                         else {
                             System.out.println("Warning: " + name + " is not registered in the Learners!");
                             break;
                         }
                         status = ssm.displayLearnerBookedSession(l);
                         if (status) { 
                             s = promptSession(sc,"Select the already booked Session: ");
                             ssm.displayUpComingSession();
                             ns = promptSession(sc,"Select the Session which you want to book: ");
                             status = ssm.changeSession(s,ns,l);
                             if (status) 
                                 System.out.println("Reschedule of booking is Sucessful!");
                             else
                                 System.out.println("Reschedule of booking is Unsucessful!");
                         }
                         else {
                                 System.out.println(l.getName() + ": No booking found for Learner");
                         }
                         break;

                case 5 : name = getString(sc, "Enter the Learner's Name: ");
                         if (ssm.isLearnerRegister(name)) {
                             l = ssm.findLearner(name);
                         }
                         else {
                             System.out.println("Warning: " + name + " is not registered in the Learners!");
                             break;
                         }
                         if (l.getNumberBooking() > 0 ) {
                             ssm.displayLearnerBookedSession(l);
                             s = promptSession(sc,"Select the already booked Session: ");
                             // Testting in the learner update
                             if (l.isSessionExists(s)) {
                                 if (l.getGrade() <= s.getGrade()) {
                                     l.updateSession(s);
                                     // updateing in SSM
                                     lIndex =  ssm.getLearnerIndex(l);
                                     if(lIndex == -1)
                                         System.out.println("Error:  Learner: " + l.getName() + "  not able to find");
                                     ssm.updateLearner(lIndex,l);
                                     System.out.println("Learner has Attended Session!");
                                     
                                     // updating in Session Manager Session list
                                     status = ssm.removeLearner(s,l);
                                     System.out.println(status);
                                     coachName = s.getCoach().getName();
                                     String comment = getString(sc, "Enter the review comment as a line: ");
                                     int rating = getInt(sc, "Enter the review rating: ",1,5,"Warning: Please enter the integer only!");
                                     Review r = new Review(l.getName(), rating,comment);
                                     c = ssm.findCoach(coachName);
                                     weekNumber = s.getWeek();
                                     c.addReview(1+(int)(Math.abs(weekNumber/4.3454)),r);
                                 }
                                 else {
                                     l.removeSession(s);
                                     ssm.removeLearner(s,l);
                                     System.out.println("Learner can't attend session with lower grade level!");
                                 }
                             }
                             else {
                                 System.out.println("Learner didn't book the entered session!");
                             }
                         }
                         else {
                             System.out.println("Learner didn't book any session!");
                         }

                         break;
                case 6 : ssm.displaySessionReport();
                         break;

                case 7 :
                         monthNumber = getInt(sc, "Enter the month (1,2,...12): ",1,12,"Warning: Please enter integer value between 1 to 12");
                         ssm.displayLearnerReport(monthNumber);
                         break;

                case 8 : 
                         monthNumber = getInt(sc, "Enter the month (1,2,...12): ",1,12,"Warning: Please enter integer value between 1 to 12");
                         ssm.displayCoachReport(monthNumber);
                         break;

                case 9 : 
                         monthNumber = getInt(sc, "Enter the month (1,2,...12): ",1,12,"Warning: Please enter integer value between 1 to 12");
                         ssm.displayMonthlyReport(monthNumber);
                         break;

                case 10 : run = false;
                          break;
                
                default: System.out.println("Invalid Options!");
                         break;
            }
        }

        // write sessionManager to database.txt file
        writeDataBase(ssm);

    }

    public static String getString(Scanner sc, String msg) {
        String value = "";
        System.out.print(msg);
        while (sc.hasNextLine()) {
            value = sc.nextLine();
            if (!value.isEmpty())
                break;
        }
        return value;
    }

    public static int getInt(Scanner sc, String msg, int min, int max, String warning) {
        boolean tryagain;
        String value;
        do {
            System.out.print(msg);
            value = sc.nextLine();
            if (!value.matches("^[0-9]*")){
                System.out.println("Enter only integer value!");
                value  = sc.nextLine();
                tryagain = true;
            }
            else if (value.isEmpty()){
                tryagain = true;
            }
            else {
                int t = Integer.valueOf(value);
                if (t >= min && t <= max) {
                    tryagain = false;
                }
                else {
                    System.out.println(warning);
                    tryagain = true;
                }
            }
        } while (tryagain); 
        return Integer.valueOf(value);
    }
    

    // Prompt a session
    public static Session promptSession(Scanner sc, String msg) {
        Session s = null;
        boolean tryagain;
        System.out.println(msg);
        String day;
        String time;
        int weekNumber;
        do {
            while(true){
                day = getString(sc,"Enter the day (Monday, Wednesday, Friday, or Saturday): ");
                if ( day.equals("Monday") || day.equals("Wednesday") || day.equals("Friday") || day.equals("Saturday"))
                    break;
                else
                    System.out.println(day + " not a valid day!");
            }
            while(true){
                time = getString(sc, "Enter the time of booking (2-3pm,3-4pm,4-5pm,5-6pm,6-7pm): ");
                if ( time.equals("2-3pm") || time.equals("3-4pm") || time.equals("4-5pm") || time.equals("5-6pm") || time.equals("6-7pm"))
                    break;
                else
                    System.out.println(time + " not a valid time!");
            }
            weekNumber = getInt(sc, "Enter the week of the booking (1,2..52):", 1, 52, "Error: enter week number between 1 to 52 inclusive.");
            if (ssm.isValidSlot(day, time, weekNumber)) {
                s = ssm.findSession(day,time,weekNumber);
                tryagain = false;
            } else {
                tryagain = true;
            }
        } while (tryagain);
        return s;
    }




    // Prompting Learner from user 
    public static Learner promptLearner(Scanner sc) {
        String name =  getString(sc, "Enter the Learner's Name: ");
        String gender;
        while(true){
            gender = getString(sc,"Enter the Learner's Gender: ");
            if (  gender.equals("male") || gender.equals("female") || gender.equals("Male") || gender.equals("Female") || gender.equals("M") || gender.equals("F"))
                break;
            else
                System.out.println(gender + " is not a valid gender option!");
        }
        int age =  getInt(sc, "Enter the Learner's Age: ",4,11,"Error: enter age between 4 to 11 inclusive.");
        String phone =  getString(sc, "Enter the Learner's Phone: ");
        String emergency =  getString(sc, "Enter the Learner's Emergency Contact: ");
        int gradeLevel =  getInt(sc, "Enter the Learner's Grade Level: ",0,5,"Error: enter grade level between  0 to 5 inclusive.");
        Learner l = new Learner(name,gender,age,phone,emergency,gradeLevel);
        return l;
    }

    // Prompt and find Session for booking
    public static Session promptAndFindSession(Scanner sc) {
        Session s = null;
        boolean tryagain;
        String day;
        String time;
        int weekNumber;
        do {
            while(true){
                day = getString(sc,"Enter the day (Monday, Wednesday, Friday, or Saturday): ");
                if ( day.equals("Monday") || day.equals("Wednesday") || day.equals("Friday") || day.equals("Saturday"))
                    break;
                else
                    System.out.println(day + " not a valid day!");
            }
            while(true){
                time = getString(sc, "Enter the time of booking (2-3pm,3-4pm,4-5pm,5-6pm,6-7pm): ");
                if ( time.equals("2-3pm") || time.equals("3-4pm") || time.equals("4-5pm") || time.equals("5-6pm") || time.equals("6-7pm"))
                    break;
                else
                    System.out.println(time + " not a valid time!");
            }
            weekNumber = getInt(sc, "Enter the week of the booking (1,2..52):", 1, 52, "Error: enter week number between 1 to 52 inclusive.");
            if (ssm.isValidSlot(day, time, weekNumber)) {
                s = ssm.findSession(day,time,weekNumber);
                tryagain = false;
            } else {
                tryagain = true;
            }
        } while (tryagain);
        return s;
    }

    // Loading the database from database.obj file
    public static SessionManager readDatabase() {
        String fileName= "database.obj";
        ObjectInputStream ois = null;
        SessionManager ssm = null;

        try {
            ois = new ObjectInputStream(new FileInputStream(fileName));
            ssm = (SessionManager) ois.readObject();
        } catch (IOException e) {
            System.out.println("Error: IOException is caught!");
            try { 
                ssm = readFile();
            }catch (IOException e1) {
                ssm = new SessionManager();
            }
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotfound is caught!");
            try { 
                ssm = readFile();
            }catch (IOException e1) {
                ssm = new SessionManager();
            }
        }finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    System.out.println("4");
                }
            }
        }

        return ssm; 
    }

    // Writing the database into the database.obj file
    public static void writeDataBase(SessionManager ssm){
        String fileName= "database.obj";
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(ssm);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    System.out.println("4");
                }
            }
        }
    }


    // First Time Initialize the data from loading 
    public static SessionManager readFile() throws IOException{
        String filename = "defaultInput.txt";
        SessionManager ssm = new SessionManager();
        FileInputStream fin = null;
        BufferedReader reader = null;
        try{
            fin = new FileInputStream(filename);
            reader = new BufferedReader(new InputStreamReader(fin));
            String line = reader.readLine();
            int readFlag = -1; // 1:Coach, 2:Session, 3:Learner
            ArrayList<TimeSlot> timeslots = ssm.generateSlots();
            while(line != null){
                line = line.replace("\n", "").replace("\r", "");
                // System.out.println(line);
                if (line.equals("Coach:")){
                    readFlag = 1;
                }
                else if (line.equals("Session:")) {
                    for (TimeSlot t: timeslots ) {
                        int index = randomGenerator.nextInt(ssm.getNumberCoaches());
                        int gradeLevel = 1 + randomGenerator.nextInt(5);
                        Session s = new Session(t, ssm.getCoach(index),gradeLevel);
                        ssm.addSession(s);
                    }
                }
                else if (line.equals("Learner:")) {
                    readFlag = 2;
                }
                else {
                    if (readFlag == 1) {
                        List<String> tempList = Arrays.asList(line.split(","));
                        Coach c = new Coach(tempList.get(0), tempList.get(1), Integer.valueOf(tempList.get(2)), tempList.get(3), Integer.valueOf(tempList.get(4)));
                        ssm.addCoach(c);
                    }
                    else if (readFlag == 2) {
                        List<String> nameList = Arrays.asList(line.split(","));
                        line = reader.readLine();
                        List<String> genderList = Arrays.asList(line.split(","));
                        line = reader.readLine();
                        List<String> ageList = Arrays.asList(line.split(","));
                        line = reader.readLine();
                        List<String> phoneList = Arrays.asList(line.split(","));
                        line = reader.readLine();
                        List<String> emergencyList = Arrays.asList(line.split(","));
                        line = reader.readLine();
                        List<String> gradeList = Arrays.asList(line.split(","));
                        int bookingDone = 0;
                        int nameIndex = 0;
                        while (bookingDone < 50) {
                            //System.out.println(line);
                            int genderIndex = randomGenerator.nextInt(genderList.size());
                            int ageIndex = randomGenerator.nextInt(ageList.size());
                            int phoneIndex = randomGenerator.nextInt(phoneList.size());
                            int emergencyIndex = randomGenerator.nextInt(emergencyList.size());
                            int gradeIndex = randomGenerator.nextInt(gradeList.size());
                            Learner l =  new Learner(nameList.get(nameIndex), genderList.get(genderIndex), Integer.valueOf(ageList.get(ageIndex)),phoneList.get(phoneIndex),emergencyList.get(emergencyIndex),Integer.valueOf(gradeList.get(gradeIndex)));
                            int sessionIndex = randomGenerator.nextInt(ssm.getNumberSessions());
                            Session s = ssm.getSession(sessionIndex);
                            boolean status = ssm.bookSession(s,l);
                            if (status) {
                                nameIndex += 1;
                                bookingDone += 1;
                            }
                        }

                    }
                }
                line = reader.readLine();
            }          
        }catch (IOException e) {
            System.out.println("Error: "+ filename + " not found!");
        }finally {
            fin.close();
        }
        return ssm;
    }


    private static void displayMenu() {
        System.out.println("\n*********************************************************");
        System.out.println("Select the below Options [1-10]");
        System.out.println("*********************************************************");
        System.out.println("1.  Register a Learner");
        System.out.println("2.  Book a Session");
        System.out.println("3.  Cancel a Session");
        System.out.println("4.  Reschedule the Session");
        System.out.println("5.  Attend the Session");
        System.out.println("6.  Display Session Report");
        System.out.println("7.  Display Monthly Learner Report");
        System.out.println("8.  Display Monthly Coach Report");
        System.out.println("9.  Display Monthly Report");
        System.out.println("10. Exit ");
        System.out.println("*********************************************************");

    }
}
