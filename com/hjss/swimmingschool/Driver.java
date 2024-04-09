package com.hjss.swimmingschool;
import java.io.*;
import java.util.Scanner;  // Import the Scanner class


public class Driver {

    private static SessionManager ssm;

    public static void main(String[] args) throws Exception {
//

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
                
                case 7 : run = false;
                         break;

                default: System.out.println("Invalid Options!");
                         break;
            }
        }

        // write sessionManager to database.txt file
        writeDataBase(ssm);

    }


    public static void readFile(){
        String fileName= "defaultInput.txt";

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
        System.out.println("7. Exit ");
        System.out.println("*************************************");
    }
}
