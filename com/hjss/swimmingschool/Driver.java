package com.hjss.swimmingschool;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;  // Import the Scanner class
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Random;

public class Driver {

    private static SessionManager ssm;
    private static Random randomGenerator = new Random();
    public static void main(String[] args) throws Exception {

        // creating an object of Scanner Class
        Scanner sc = new Scanner(System.in);
        
        // Setting welcome msg
        System.out.println("Welcome to the Hatfield Junior Swimming School");

        int optionNumber = 1;
        // setting run to true for running a loop until user exit

        boolean run = true;
        // Runing a loop until user choose to exit
        
        // read database.txt file
        ssm = readDatabase();

        while (run) {

            // displaying Menu
            displayMenu();
            
            System.out.print("Enter your options: ");
            optionNumber = sc.nextInt();

            switch(optionNumber) {
            
                case 1 : ssm.registerLearner();
                         break;

                case 2 : ssm.registerCoach();
                         break;
                
                case 3 : ssm.bookSession();
                         break;

                case 4 : ssm.cancelSession();
                         break;
                
                case 5 : ssm.changeSession();
                         break;
                
                case 6 : ssm.writeReview();
                         break;

                case 7: ssm = readFile();
                        ssm.printCoachs();
                        ssm.printSessions();
                        ssm.printLearners();
                        break;

                case 8 : run = false;
                         break;

                default: System.out.println("Invalid Options!");
                         break;
            }
        }

        // write sessionManager to database.txt file
        writeDataBase(ssm);

    }

    public static SessionManager readDatabase() {
        String fileName= "database.obj";
        ObjectInputStream ois = null;
        SessionManager ssm = null;

        try {
            ois = new ObjectInputStream(new FileInputStream(fileName));
            ssm = (SessionManager) ois.readObject();
        }catch (FileNotFoundException e) {
            System.out.println("1");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("3");
        } catch (ClassCastException e) {
                System.out.println("4");
        } finally {
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
                if (line.equals("Coach:")){
                    readFlag = 1;
                }
                else if (line.equals("Session:")) {
                    for (TimeSlot t: timeslots ) {
                            int index = randomGenerator.nextInt(ssm.getNumberCoaches());
                            int gradeLevel = randomGenerator.nextInt(5);
                            Session s = new Session(t, ssm.getCoachName(index),gradeLevel);
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
                        while (bookingDone < 50) {
                            int nameIndex = randomGenerator.nextInt(nameList.size());
                            int genderIndex = randomGenerator.nextInt(genderList.size());
                            int ageIndex = randomGenerator.nextInt(ageList.size());
                            int phoneIndex = randomGenerator.nextInt(phoneList.size());
                            int emergencyIndex = randomGenerator.nextInt(emergencyList.size());
                            int gradeIndex = randomGenerator.nextInt(gradeList.size());
                            Learner l =  new Learner(nameList.get(nameIndex), genderList.get(genderIndex), Integer.valueOf(ageList.get(ageIndex)),phoneList.get(phoneIndex),emergencyList.get(emergencyIndex),Integer.valueOf(gradeList.get(gradeIndex)));
                            int sessionIndex = randomGenerator.nextInt(ssm.getNumberSessions());
                            Session s = ssm.getSession(sessionIndex);
                            boolean status = ssm.bookSession(s,l);
                            if (status) 
                                bookingDone += 1;
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

    public static void writeDataBase(SessionManager ssm){
        String fileName= "database.obj";
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(ssm);
        }catch (FileNotFoundException e) {
            System.out.println("1");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            System.out.println("4");
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

    private static void displayMenu() {
        System.out.println("\n*************************************");
        System.out.println("Select the below Options [1-7]");
        System.out.println("1. Register a Learner: ");
        System.out.println("2. Register a Coach: ");
        System.out.println("3. Book a Session: ");
        System.out.println("4. Cancel a Session: ");
        System.out.println("5. Change a Session: ");
        System.out.println("6. Write a Review for a Session: ");
        System.out.println("7. Read a file ");
        System.out.println("8. Exit ");
        System.out.println("*************************************");
    }
}
