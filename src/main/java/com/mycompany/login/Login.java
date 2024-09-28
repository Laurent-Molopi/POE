/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login;

/**
 *
 * @author south
 */
public class Login {
//   declarations with private classes
    private String username;
    private String password;
    private String firstname;
    private String lastname;

 public Login (String username,String password,
    String firstsname, String lastname){ 
        this.username= username;
        this.password= password;
        this.firstname = firstname;
        this.lastname= lastname;
                
    }
 
 public Login (){
                }
 
 public void setFirstName(String firstName) {
    this.firstname = firstName;  // Correctly assign the parameter to the field
}

public void setLastName(String lastName) {
    this.lastname = lastName;  // Correctly assign the parameter to the field
}

 public String getFirstName() {
    return this.firstname;
}


public String getLastName() {
    return this.lastname;
}


public String getUsername() {
    return this.username;
}

public void setUsername(String username) {
    this.username = username;
}

public String getPassword() {
    return this.password;
}

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


// if Statements
 public String registerUser() {
        if (!checkusername()) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
        if (!checkPasswordcomplexity()) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        }
        return "Username successfully captured\nPassword successfully captured";
    }
 
 public boolean loginUser(String username,String password){
 return this.username.equals(username) && 
         this.password.equals(password);
         }
 
 public String returnLoginStatus(boolean loginStatus){
     if (loginStatus){
     return "Welcome " + firstname + ", " + lastname + " it is great to see you again.";
 }
    return "Username or password incorrect, please try again";
 }
 
 
 public void CreatAccount(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        System.out.println("Account created successfully!");
    }
 
 
 
  }