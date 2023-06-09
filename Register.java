
// package com.mycompany.toffee;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;


/**
 * This class is represents the registration process 
 */

public class Register {

    private String username;
    private String password;
    private String name;
    private String ID;
    private String phonenumber;
    private String email;

   
    
    /** 
     * @param customer
     * The method prompts the user to enter their username, email, password, name, and phone number. It performs validation on the entered values and saves the user’s credentials to a file if all values are valid
     */
    public static void register(Customer customer) {

    Scanner scanner = new Scanner(System.in);

    System.out.println("Welcome to User Registration");

    

    while(true){
        System.out.print("Enter your username (must be at least 4 characters long): ");
        String username = scanner.nextLine();

        if (username.length() < 4) {
            System.out.println("Username must be at least 4 characters long. Please try again.");
        }  else if (usernameExists(username)) {
            System.out.println("Username already exists. Please try again with a different username.");
        } else {
            customer.setUserName(username);
            break;
        }
    }

    // Prompt user for username
    while (true) {
       System.out.print("Enter Valid Email: ");
        String userEmail = scanner.nextLine();

        String regexPattern = "^(.+)@(\\S+)$";

    

      
        if (!userEmail.matches(regexPattern)) {
            System.out.println("Email is invalid");
        }  else if (userEmailused(userEmail)) {
            System.out.println("This email is already used, try another one");
        } else {
            
            // sending otp to validate the email
            OTP otp = new OTP() ;
            otp.sendOTP(userEmail);
            String sendedOTP = otp.getOTP();

            System.out.print("Enter otp:");
            String enterdOtp = scanner.nextLine();

            // while(sendedOTP != enterdOtp ){
            //     System.out.print("Wrong Otp! Enter the otp again:");
            //     enterdOtp = scanner.nextLine();

            // }
            customer.setEmail(userEmail);

    
            break;
        }

      
    }

    while (true) {
        System.out.print("Enter your password (must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, and one digit): ");
        String password = scanner.nextLine();

        if (password.length() < 8) {
            System.out.println("Password must be at least 8 characters long. Please try again.");
        } else if (!password.matches(".*[A-Z].*")) {
            System.out.println("Password must contain at least one uppercase letter. Please try again.");
        } else if (!password.matches(".*[a-z].*")) {
            System.out.println("Password must contain at least one lowercase letter. Please try again.");
        } else if (!password.matches(".*\\d.*")) {
            System.out.println("Password must contain at least one digit. Please try again.");
        } else {
            customer.setPassword(password);
            break;
        }
    }

    while (true) {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        if (name.length() < 3) {
            System.out.println("Name must be at least 3 characters long. Please try again.");
        } else {
            customer.setUserName(name);
            break;
        }
    }
    while (true) {
        System.out.print("Enter your phone number: ");
        String phoneNo = scanner.nextLine();
        if (phoneNo.length() != 11) {
            System.out.println("Phone number must be exactly 11 digits long. Please try again.");
        } else if (!phoneNo.matches("\\d+")) {
            System.out.println("Phone number must contain digits only. Please try again.");
        } else {
            customer.setPhoneNo(phoneNo);
            break;
        }
    }

    // Save user credentials to file
    try {
        FileWriter writer = new FileWriter("login.txt", true);
        writer.write(customer.getEmail()+ "," + customer.getPassword() + "," +customer.getUserName()+ "," + customer.getPhoneNo() + "\n");
        writer.close();
        System.out.println("User registered successfully.");
    } catch (IOException e) {
        System.out.println("An error occurred while registering user.");
        e.printStackTrace();
    }
}
    
    /** 
     * @param userEmail
     * @return boolean
     * this method check if the entered email already exists in the login file
     */
    private static boolean userEmailused(String userEmail) {
        try {
            File file = new File("login.txt");
            if (!file.exists()) {
                return false;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4 && parts[0].equals(userEmail)) {
                    reader.close();
                    return true;
                }
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the login file.");
            e.printStackTrace();
        }

        return false;
    }



    
    /** 
     * @param username
     * @return boolean
     * this method check if the entered  username already exists in the login file
     */
    private static boolean usernameExists(String username) {
        try {
            File file = new File("login.txt");
            if (!file.exists()) {
                return false;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4 && parts[0].equals(username)) {
                    reader.close();
                    return true;
                }
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the login file.");
            e.printStackTrace();
        }

        return false;
    }
}



   




