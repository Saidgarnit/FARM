package com.example.login.Controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LoginControllerTest {

    @BeforeAll
    public static void initJavaFX() {
        Platform.startup(() -> {
            // This method will be invoked in the JavaFX thread
        });
    }
    @Test
    void signUpActionTest() {
        Platform.runLater(() -> {
            // Create an instance of the LoginController
            LoginController loginController = new LoginController();

            // Assign values directly to the fields within LoginController (hypothetical scenario)
            // ...

            Hyperlink signUpLink = new Hyperlink();
            Button signUpButton = new Button();
            ActionEvent actionEvent = new ActionEvent(signUpButton, null);

            // Perform the sign-up action and add your assertions based on the expected behavior
            assertDoesNotThrow(() -> loginController.signUpAction(actionEvent));
            // Add assertions for the expected behavior after sign-up
        });
    }
}
