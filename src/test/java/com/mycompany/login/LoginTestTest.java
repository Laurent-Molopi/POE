/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.login;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the Login class.
 */
public class LoginTestTest {

    private Login system;

    @BeforeEach
    public void setup() {
        // Initialize a new instance of Login before each test
        system = new Login(); 
    }

    @Test
    public void testUsernameCorrectlyFormatted() {
         // Set a valid username
        system.setUsername("kyl_1");
        assertTrue(system.checkUsername(), "Username should be correctly formatted"); 
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        // Set an invalid username
        system.setUsername("kyle!!!!!!!");
        assertFalse(system.checkUsername(), "Username should be incorrectly formatted");
    }

    @Test
    public void testPasswordMeetsComplexityRequirements() {
        // Set a valid password
        system.setPassword("Ch&&sec@ke99!"); 
        assertTrue(system.checkPasswordComplexity(), "Password should meet complexity requirements"); 
    }

    @Test
    public void testPasswordDoesNotMeetComplexityRequirements() {
        // Set an invalid password
        system.setPassword("password"); 
        assertFalse(system.checkPasswordComplexity(), "Password should not meet "
                + "complexity requirements");
    }

    @Test
    public void testRegisterUserValidUsernameAndPassword() {
        // Set a valid username
        system.setUsername("kyl_1"); 
        // Set a valid password
        system.setPassword("Ch&&sec@ke99!");
        String registrationStatus = system.registerUser();
        assertEquals("Username successfully captured\nPassword successfully captured", registrationStatus, 
                     "The registration should be successful with valid username and password.");
    }

    @Test
    public void testRegisterUserInvalidUsername() {
        // Set an invalid username
        system.setUsername("kyle!!!!!!!"); 
        // Set a valid password
        system.setPassword("Ch&&sec@ke99!");        
        String registrationStatus = system.registerUser();
        assertEquals("Username is not correctly formatted, please ensure that "
                + "your username contains an underscore and is no more than 5 characters in length.", 
                     registrationStatus, 
                     "The registration should fail with an invalid username.");
    }

    @Test
    public void testRegisterUserInvalidPassword() {
        // Set a valid username
        system.setUsername("kyl_1"); 
         // Set an invalid password
        system.setPassword("password");
        String registrationStatus = system.registerUser(); 
        assertEquals("Password is not correctly formatted, please ensure that "
        + "the password contains at least 8 characters, a capital letter, a number and a special character.", 
                     registrationStatus, 
                     "The registration should fail with an invalid password.");
    }

    @Test
    public void testLoginSuccess() {
         // Create an account
        system.createAccount("kyl_1", "Ch&&sec@ke99!", "John", "Doe");
         // Attempt login
        boolean loginStatus = system.loginUser("kyl_1", "Ch&&sec@ke99!");
        assertTrue(loginStatus, "Login should be successful with correct username and password.");
    }

    @Test
    public void testLoginFailure() {
        // Create an account
        system.createAccount("kyl_1", "Ch&&sec@ke99!", "John", "Doe"); 
        // Attempt login with wrong password
        boolean loginStatus = system.loginUser("kyl_1", "wrongpassword"); 
        assertFalse(loginStatus, "Login should fail with incorrect password."); 
    }

    @Test
    public void testReturnLoginStatusSuccess() {
         // Create an account
        system.createAccount("kyl_1", "Ch&&sec@ke99!", "John", "Doe");
        // Attempt login
        boolean loginStatus = system.loginUser("kyl_1", "Ch&&sec@ke99!"); 
        // Get login message
        String loginMessage = system.returnLoginStatus(loginStatus); 
        assertEquals("Welcome John, Doe it is great to see you again.", 
                loginMessage, "The login status message should indicate a successful login.");
    }

    @Test
    public void testReturnLoginStatusFailure() {
        // Create an account
        system.createAccount("kyl_1", "Ch&&sec@ke99!", "John", "Doe"); 
        // Attempt login with wrong password
        boolean loginStatus = system.loginUser("kyl_1", "wrongpassword"); 
         // Get login message
        String loginMessage = system.returnLoginStatus(loginStatus);
        assertEquals("Username or password incorrect, please try again", 
        loginMessage, "The login status message should indicate a failed login.");
    }
}
