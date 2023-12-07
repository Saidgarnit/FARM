package com.example.login;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SessionManagerTest {

    private SessionManager sessionManager;

    @BeforeEach
    public void setUp() {
        sessionManager = SessionManager.getInstance();
    }

    @Test
    public void testGetInstance() {
        assertNotNull(sessionManager);
        assertEquals(sessionManager, SessionManager.getInstance());
    }

    @Test
    public void testSetAndGetLoggedInAdminEmail() {
        String email = "admin@example.com";
        sessionManager.setLoggedInAdminEmail(email);

        assertEquals(email, sessionManager.getLoggedInAdminEmail());
    }
}
