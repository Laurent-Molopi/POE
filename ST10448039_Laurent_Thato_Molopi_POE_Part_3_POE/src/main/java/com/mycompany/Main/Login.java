/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Main;
/**
 *
 * @author south
 */
public class Login {
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    public boolean checkUserName(String username) {
        // Ensures username contains an underscore and is no more than 5 characters
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        // Ensures password meets the complexity requirements
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&  // Contains a capital letter
               password.matches(".*[0-9].*") && // Contains a number
               password.matches(".*[!@#$%^&*()].*"); // Contains a special character
    }

    public String registerUser(String username, String password, String firstName, String lastName) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        }
        // Save user details if both username and password are valid
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        return "User successfully registered!";
    }

    public boolean loginUser(String username, String password) {
        // Verifies if the login details match the registered user
        return this.username != null && this.username.equals(username) && this.password.equals(password);
    }

    public String returnLoginStatus(String username, String password) {
        // Returns appropriate login messages
        if (loginUser(username, password)) {
            return "Welcome " + firstName + " " + lastName + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
