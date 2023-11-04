package com.example.login;

public class SessionManager {
    private static SessionManager instance;
    private String loggedInAdminEmail;

    private SessionManager() {
        // Private constructor to prevent instantiation.
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public String getLoggedInAdminEmail() {
        return loggedInAdminEmail;
    }

    public void setLoggedInAdminEmail(String email) {
        loggedInAdminEmail = email;
    }
}
