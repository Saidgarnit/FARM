package com.example.login.Models;

import com.example.login.Models.Admin;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdminTest {



    @Test
    void adminSettersAndGettersTest() {
        // Create an Admin instance
        Admin admin = new Admin("John Doe", "john@example.com", "123456789", 30, LocalDate.of(1990, 5, 15), "password", "image.jpg");

        // Test the setters and getters
        admin.setFullName("Jane Doe");
        admin.setEmail("jane@example.com");
        admin.setTelephone("987654321");
        admin.setAge("35");
        admin.setDateOfBirth(LocalDate.of(1987, 3, 10));
        admin.setPassword("newPassword");
        admin.setImagePath("newImage.jpg");

        assertEquals("Jane Doe", admin.getFullName());
        assertEquals("jane@example.com", admin.getEmail());
        assertEquals("987654321", admin.getTelephone());
        assertEquals(35, admin.getAge());
        assertEquals(LocalDate.of(1987, 3, 10), admin.getDateOfBirth());
        assertEquals("newPassword", admin.getPassword());
        assertEquals("newImage.jpg", admin.getImagePath());
    }
}
