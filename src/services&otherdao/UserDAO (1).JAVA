package com.pawsandhearts.dao;

import com.pawsandhearts.model.User;
import java.sql.*;

public class UserDAO {
    private Connection connection;

    public UserDAO() {
        // Set up the database connection (you can use a database connection pool in real applications)
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pet_adoption", "root", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Register a new user
    public boolean registerUser(User user) {
        String query = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Update user profile
    public boolean updateUserProfile(User user) {
        String query = "UPDATE users SET name = ?, email = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setLong(3, user.getId());

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
