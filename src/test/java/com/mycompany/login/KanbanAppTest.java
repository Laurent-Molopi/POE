/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author south
 */
public class KanbanAppTest {

    @Test
    public void testCheckTaskDescriptionSuccess() {
        Task task = new Task("Login Feature", 0, "Short description", "John Doe", 5, "To Do");
        assertTrue(task.checkTaskDescription(), "Task description should be within 50 characters.");
    }

    @Test
    public void testCheckTaskDescriptionFailure() {
        Task task = new Task("Login Feature", 0, "This description is way too long and exceeds the fifty character limit", "John Doe", 5, "To Do");
        assertFalse(task.checkTaskDescription(), "Task description should exceed 50 characters and fail.");
    }

    @Test
    public void testCreateTaskID() {
        Task task = new Task("Login Feature", 1, "Create Login", "Robyn Harrison", 8, "To Do");
        assertEquals("LO:1:SON", task.createTaskID(), "Task ID should match the expected format.");
    }

    @Test
    public void testTotalDurationAccumulation() {
        Task task1 = new Task("Task1", 0, "Description1", "Dev One", 8, "To Do");
        Task task2 = new Task("Task2", 1, "Description2", "Dev Two", 10, "Doing");

        int totalHours = task1.returnTotalHours() + task2.returnTotalHours();
        assertEquals(18, totalHours, "Total hours should accumulate correctly.");
    }

    // Additional tests can be added for edge cases and other features as per project requirements.
}
