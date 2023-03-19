package io.github.Lossttt.athenavox;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginController {
    
    @FXML
    private TextField usernameField;
    
    @FXML
    private PasswordField passwordField;
    
    @FXML
    private Button loginButton;
    
    @FXML
    private Text errorText;
    
    public void initialize() {
        // Set up event handling for login button
        loginButton.setOnAction(e -> handleLogin());
    }
    
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        // Check if username and password are valid (e.g. match with database)
        if (username.equals("validuser") && password.equals("validpassword")) {
            // Login successful, navigate to main app window
            System.out.println("Login successful!");
            // Replace the following line with code to navigate to main app window
            errorText.setText("Login successful!");
        } else {
            // Login failed, display error message
            errorText.setText("Invalid username or password");
        }
    }
    
}