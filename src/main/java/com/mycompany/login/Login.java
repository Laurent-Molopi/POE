/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login;

/**
 *
 * @author south
 */
public class Login {
    // Declarations with private classes
    private String username;
    private String password;
    private String firstname;
    private String lastname;

    // Default constructor for the Login class
    public Login() {}

    // Setter method for the user's first name
    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    // Setter method for the user's last name
    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    // Getter method for the user's first name
    public String getFirstName() {
        return this.firstname;
    }

    // Getter method for the user's last name
    public String getLastName() {
        return this.lastname;
    }

    // Getter method for the user's username
    public String getUsername() {
        return this.username;
    }

    // Setter method for the user's username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter method for the user's password
    public String getPassword() {
        return this.password;
    }

    // Setter method for the user's password
    public void setPassword(String password) {
        this.password = password;
    }

    // Boolean that checks if the username contains required fields
    public boolean checkUsername() {
        return username.contains("_") && username.length() <= 5;
    }

    // Boolean that checks if the password meets the requirements
    public boolean checkPasswordComplexity() {
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&  // At least one uppercase letter
               password.matches(".*[0-9].*") &&  // At least one digit
               password.matches(".*[!@#$%^&*()_+-=].*");  // At least one special character
    }

    // Method to register a user by checking the validity of username and password
    public String registerUser() {
        if (!checkUsername()) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        }
        return "Username successfully captured\nPassword successfully captured";
    }

    // Method to verify login credentials
    public boolean loginUser(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    // Method to return a message based on the login status
    public String returnLoginStatus(boolean loginStatus) {
        if (loginStatus) {
            return "Welcome " + firstname + " " + lastname + ", it is great to see you again.";
        }
        return "Username or password incorrect, please try again";
    }

    // Method to create an account by setting the user's details: username, password, first name, and last name
    public void createAccount(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstname = firstName;
        this.lastname = lastName;
        System.out.println("Account created successfully!");
    }
}
