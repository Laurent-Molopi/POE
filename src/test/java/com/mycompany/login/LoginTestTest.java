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
        system = new Login(); // Initialize a new instance of Login before each test
    }

    @Test
    public void testUsernameCorrectlyFormatted() {
        system.setUsername("kyl_1"); // Set a valid username
        assertTrue(system.checkusername(), "Username should be correctly formatted"); // Check formatting
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        system.setUsername("kyle!!!!!!!"); // Set an invalid username
        assertFalse(system.checkusername(), "Username should be incorrectly formatted"); // Check formatting
    }

    @Test
    public void testPasswordMeetsComplexityRequirements() {
        system.setPassword("Ch&&sec@ke99!"); // Set a valid password
        assertTrue(system.checkPasswordcomplexity(), "Password should meet complexity requirements"); // Check complexity
    }

    @Test
    public void testPasswordDoesNotMeetComplexityRequirements() {
        system.setPassword("password"); // Set an invalid password
        assertFalse(system.checkPasswordcomplexity(), "Password should not meet "
                + "complexity requirements"); // Check complexity
    }

    @Test
    public void testRegisterUserValidUsernameAndPassword() {
        system.setUsername("kyl_1"); // Set a valid username
        system.setPassword("Ch&&sec@ke99!"); // Set a valid password
        String registrationStatus = system.registerUser(); // Attempt registration
        assertEquals("Username successfully captured\nPassword successfully captured", registrationStatus, 
                     "The registration should be successful with valid username and password.");
    }

    @Test
    public void testRegisterUserInvalidUsername() {
        system.setUsername("kyle!!!!!!!"); // Set an invalid username
        system.setPassword("Ch&&sec@ke99!"); // Set a valid password
        String registrationStatus = system.registerUser(); // Attempt registration
        assertEquals("Username is not correctly formatted, please ensure that "
                + "your username contains an underscore and is no more than 5 characters in length.", 
                     registrationStatus, 
                     "The registration should fail with an invalid username.");
    }

    @Test
    public void testRegisterUserInvalidPassword() {
        system.setUsername("kyl_1"); // Set a valid username
        system.setPassword("password"); // Set an invalid password
        String registrationStatus = system.registerUser(); // Attempt registration
        assertEquals("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.", 
                     registrationStatus, 
                     "The registration should fail with an invalid password.");
    }

    @Test
    public void testLoginSuccess() {
        system.CreatAccount("kyl_1", "Ch&&sec@ke99!", "John", "Doe"); // Create an account
        boolean loginStatus = system.loginUser("kyl_1", "Ch&&sec@ke99!"); // Attempt login
        assertTrue(loginStatus, "Login should be successful with correct username and password."); // Check login success
    }

    @Test
    public void testLoginFailure() {
        system.CreatAccount("kyl_1", "Ch&&sec@ke99!", "John", "Doe"); // Create an account
        boolean loginStatus = system.loginUser("kyl_1", "wrongpassword"); // Attempt login with wrong password
        assertFalse(loginStatus, "Login should fail with incorrect password."); // Check login failure
    }

    @Test
    public void testReturnLoginStatusSuccess() {
        system.CreatAccount("kyl_1", "Ch&&sec@ke99!", "John", "Doe"); // Create an account
        boolean loginStatus = system.loginUser("kyl_1", "Ch&&sec@ke99!"); // Attempt login
        String loginMessage = system.returnLoginStatus(loginStatus); // Get login message
        assertEquals("Welcome John, Doe it is great to see you again.", loginMessage, "The login status message should indicate a successful login."); // Check message
    }

    @Test
    public void testReturnLoginStatusFailure() {
        system.CreatAccount("kyl_1", "Ch&&sec@ke99!", "John", "Doe"); // Create an account
        boolean loginStatus = system.loginUser("kyl_1", "wrongpassword"); // Attempt login with wrong password
        String loginMessage = system.returnLoginStatus(loginStatus); // Get login message
        assertEquals("Username or password incorrect, please try again", loginMessage, "The login status message should indicate a failed login."); // Check message
    }
}
