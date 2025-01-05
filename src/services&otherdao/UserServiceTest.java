package com.pawsandhearts.service;

import com.pawsandhearts.dao.UserDAO;
import com.pawsandhearts.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private UserService userService;
    private UserDAO userDAO;

    @BeforeEach
    void setUp() {
        userDAO = Mockito.mock(UserDAO.class);
        userService = new UserService(userDAO); // Inject mocked DAO
    }

    @Test
    void testRegisterUser() {
        User user = new User();
        user.setName("Jane Doe");
        user.setEmail("jane@example.com");
        user.setPassword("password456");

        Mockito.when(userDAO.registerUser(user)).thenReturn(true);

        boolean result = userService.registerUser(user);
        assertTrue(result, "User should be registered successfully.");
    }

    @Test
    void testUpdateUserProfile() {
        User user = new User();
        user.setId(2);
        user.setName("Updated Jane");

        Mockito.when(userDAO.updateUserProfile(user)).thenReturn(true);

        boolean result = userService.updateUserProfile(user);
        assertTrue(result, "User profile should be updated successfully.");
    }

    @Test
    void testGetUserByEmail() {
        String email = "john@example.com";
        User user = new User();
        user.setEmail(email);
        Mockito.when(userDAO.getUserByEmail(email)).thenReturn(user);

        User result = userService.getUserByEmail(email);
        assertNotNull(result, "User should be retrieved successfully.");
        assertEquals(email, result.getEmail(), "Email should match.");
    }
}
