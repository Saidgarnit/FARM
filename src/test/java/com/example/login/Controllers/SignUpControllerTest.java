package com.example.login.Controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SignUpControllerTest {
    private SignUpController signUpController;

    @BeforeEach
    void setUp() {
        signUpController = new SignUpController();
    }

    @Test
    void isValidEmail_ValidEmail_ReturnsTrue() {
        assertTrue(signUpController.isValidEmail("example@gmail.com"));
    }

    @Test
    void isValidEmail_InvalidEmail_ReturnsFalse() {
        assertFalse(signUpController.isValidEmail("invalid_email"));
    }

    @Test
    void isStrongPassword_ValidPassword_ReturnsTrue() {
        assertTrue(signUpController.isStrongPassword("aStrongPassword123"));
    }

    @Test
    void isStrongPassword_InvalidPassword_ReturnsFalse() {
        assertFalse(signUpController.isStrongPassword("weak"));
    }

    // Add more tests as needed for other methods in your SignUpController
}
