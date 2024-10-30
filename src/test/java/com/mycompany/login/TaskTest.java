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
public class TaskTest {

    // Test to ensure description length validation succeeds for valid descriptions
    @Test
    public void testCheckTaskDescription_Success() {
        Task task = new Task("Login Feature", 0, "Create Login to authenticate users", "Robyn Harrison", 8, "To Do");
        assertTrue(task.checkTaskDescription(), "Task description should be valid.");
    }

    // Test to ensure description length validation fails for overly long descriptions
    @Test
    public void testCheckTaskDescription_Failure() {
        Task task = new Task("Add Task Feature", 1, "This is an overly long task description that exceeds fifty characters.", "Mike Smith", 10, "Doing");
        assertFalse(task.checkTaskDescription(), "Task description should be too long.");
    }

    // Test to ensure that the Task ID is generated correctly
    @Test
    public void testCreateTaskID() {
        Task task = new Task("Login Feature", 1, "Create Login to authenticate users", "Robyn Harrison", 8, "To Do");
        assertEquals("LO:1:SON", task.createTaskID(), "Task ID should match expected format.");
    }

    // Test to ensure that the task duration is returned correctly
    @Test
    public void testReturnTotalHours() {
        Task task1 = new Task("Task 1", 0, "Description", "Developer", 8, "To Do");
        Task task2 = new Task("Task 2", 1, "Description", "Developer", 10, "Doing");

        assertEquals(8, task1.returnTotalHours());
        assertEquals(10, task2.returnTotalHours());
    }
}
