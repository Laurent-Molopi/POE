/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login;

/**
 *
 * @author south
 */
public class Login {
//   Declarations with private classes
    private String username;
    private String password;
    private String firstname;
    private String lastname;

 // Constructor for the Login class that initializes the user with a username, password, first name, and last name
 public Login (String username,String password,
    String firstsname, String lastname){ 
        this.username= username;
        this.password= password;
        this.firstname = firstname;
        this.lastname= lastname;
                
    }
 // Default constructor for the Login class
 public Login (){
                }
 
 // Setter method for the user's first name
 public void setFirstName(String firstName) {
    this.firstname = firstName;  // Correctly assign the parameter to the field
}

 // Setter method for the user's Last name
public void setLastName(String lastName) {
    this.lastname = lastName;  // Correctly assign the parameter to the field
}

// getter method for the user's first name
 public String getFirstName() {
    return this.firstname;
}

// getter method for the user's last name
public String getLastName() {
    return this.lastname;
}

// getter method for the user's username
public String getUsername() {
    return this.username;
}
// setter method for the user's username
public void setUsername(String username) {
    this.username = username;
}
// getter method for the user's password
public String getPassword() {
    return this.password;
}
// setter method for the user's password
public void setPassword(String password) {
    this.password = password;
}

// Boolean that checks is the username contains required fields
public boolean checkusername(){
return username.contains("_") && username.length() <=5;
}

// Boolean that checks if the password meets the requirement
public boolean checkPasswordcomplexity() {
    // Check for at least one uppercase letter, one number, and one special character
    return password.length() >= 8 &&
           password.matches(".*[A-Z].*") && // At least one uppercase letter
           password.matches(".*[0-9].*") && // At least one digit
           password.matches(".*[!@#$%^&*()_+-=].*"); // At least one special character
}


// Method to register a user by checking the validity of username and password
 public String registerUser() {
     
         // Check if the username follows the required format
        if (!checkusername()) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
         // Check if the password meets complexity requirements
        if (!checkPasswordcomplexity()) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        }
        // If both username and password are valid, return success messages
        return "Username successfully captured\nPassword successfully captured";
    }
 
 // Method to verify login credentials
    public boolean loginUser(String username,String password){
     // Check if the provided username and password match the saved credentials
    return this.username.equals(username) && 
         this.password.equals(password);
         }
    
 // Method to return a message based on the login status
 public String returnLoginStatus(boolean loginStatus){
     if (loginStatus){
         // If login is successful, return a personalized welcome message
     return "Welcome " + firstname + ", " + lastname + " it is great to see you again.";
 }
         // If login fails, return an error message
    return "Username or password incorrect, please try again";
 }
 
 
 // Method to create an account by setting the user's details username, password, first name, and last name
 public void CreatAccount(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        // Print success message once the account is created
        System.out.println("Account created successfully!");
    }
 
 
 
  }