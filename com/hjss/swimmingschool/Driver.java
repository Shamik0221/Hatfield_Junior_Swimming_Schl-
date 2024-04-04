package com.hjss.swimmingschool;
import java.util.Scanner;  // Import the Scanner class
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class Driver {


    public static void main(String[] args) throws Exception {

        SessionManager ssm = new SessionManager();

        // creating an object of Scanner Class
        Scanner sc = new Scanner(System.in);
        
        // Setting welcome msg
        System.out.println("Welcome to the Hatfield Junior Swimming School");

        int optionNumber = 1;
        // setting run to true for running a loop until user exit

        boolean run = true;
        // Runing a loop until user choose to exit
        
        // read database.txt file
        readDatabase();

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
        System.out.println("Thank for swimming with Hatfield Junior Swimming School!!");
        
        // read database.txt file
        writeDatabase(ssm);
    }


    public static SessionManager readDatabase() {
        String fileName= "database.txt";
        FileInputStream fin = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fin);
        SessionManager ssm = (SessionManager) ois.readObject();
        ois.close();
        return ssm; 
    }


    public static void writeDataBase(SessionManager ssm) throws IOException{
        String fileName= "database.txt";
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(ssm);
        oos.close();
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
