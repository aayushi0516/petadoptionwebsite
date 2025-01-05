package com.pawsandhearts.dao;

import com.pawsandhearts.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {

    private UserDAO userDAO;

    @BeforeEach
    void setUp() {
        userDAO = new UserDAO(); // Initialize UserDAO
    }

    @Test
    void testRegisterUser() {
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john@example.com");
        user.setPassword("password123");
        user.setPhoneNumber("1234567890");
        user.setAddress("123 Main St");

        boolean result = userDAO.registerUser(user);
        assertTrue(result, "User should be registered successfully.");
    }

    @Test
    void testUpdateUserProfile() {
        // Assuming there's an existing user with ID 1 in the database
        User user = new User();
        user.setId(1);
        user.setName("Updated Name");
        user.setPhoneNumber("9876543210");
        user.setAddress("Updated Address");

        boolean result = userDAO.updateUserProfile(user);
        assertTrue(result, "User profile should be updated successfully.");
    }

    @Test
    void testGetUserByEmail() {
        String email = "john@example.com";
        User user = userDAO.getUserByEmail(email);
        assertNotNull(user, "User should be retrieved by email.");
        assertEquals(email, user.getEmail(), "Email should match.");
    }

    @Test
    void testDeleteUser() {
        int userId = 1;
        boolean result = userDAO.deleteUser(userId);
        assertTrue(result, "User should be deleted successfully.");
    }
}
