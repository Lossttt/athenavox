package io.github.Lossttt.athenavox;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Hyperlink forgotPasswordLink;

    @FXML
    private void handleLoginButtonAction() {
        String username = usernameField.getText();
        String password = passwordField.getText();
    }

    // @FXML
    // private void handleForgotPasswordLinkAction() {
    //     // code to handle forgotten password
    // }

    // public class myLoginController implements Initializable {

    //     @FXML
    //     private TextField usernameField;

    //     @FXML
    //     private PasswordField passwordField;

    //     @FXML
    //     private Button loginButton;

    //     @FXML
    //     private Hyperlink forgotPasswordLink;

    //     private Stage stage;

    //     @Override
    //     public void initialize(URL location, ResourceBundle resources) {
    //         // Add event handler to the Login button
    //         loginButton.setOnAction(event -> {
    //             String username = usernameField.getText();
    //             String password = passwordField.getText();

    //             if (username.equals("myusername") && password.equals("mypassword")) {
    //                 // Load the welcome.fxml file and display it
    //                 FXMLLoader loader = new FXMLLoader(getClass().getResource("welcome.fxml"));
    //                 try {
    //                     Parent root = loader.load();
    //                     Scene scene = new Scene(root);
    //                     stage.setScene(scene);
    //                 } catch (IOException e) {
    //                     e.printStackTrace();
    //                 }
    //             } else {
    //                 // Display an error message
    //                 Alert alert = new Alert(Alert.AlertType.ERROR);
    //                 alert.setTitle("Login Failed");
    //                 alert.setHeaderText("Invalid username or password");
    //                 alert.showAndWait();
    //             }
    //         });

    //         // Add event handler to the Forgot Password link
    //         forgotPasswordLink.setOnAction(event -> {
    //             // Implement code to handle forgotten passwords
    //         });
    //     }

    //     public void setStage(Stage stage) {
    //         this.stage = stage;
    //     }
    // }

    //     public static void setStage(Stage primaryStage) {
    // }
}
