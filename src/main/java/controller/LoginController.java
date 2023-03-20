package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Node;

public class LoginController implements Initializable {

    private Scene scene;

    @FXML
    Stage stage;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Text errorText;

    // public void initialize() {
    // // Set up event handling for login button
    // loginButton.setOnAction(e -> handleLogin());
    // }

    // private void handleLogin() {
    // String username = usernameField.getText();
    // String password = passwordField.getText();

    // // Check if username and password are valid (e.g. match with database)
    // if (username.equals("validuser") && password.equals("validpassword")) {
    // // Login successful, navigate to main app window
    // System.out.println("Login successful!");
    // // Replace the following line with code to navigate to main app window
    // errorText.setText("Login successful!");
    // } else {
    // // Login failed, display error message
    // errorText.setText("Invalid username or password");
    // }
    // }

    public void login(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("welcome.fxml")));
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initialize'");
    }

}