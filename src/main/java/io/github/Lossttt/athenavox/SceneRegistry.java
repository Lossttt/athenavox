package io.github.Lossttt.athenavox;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class SceneRegistry {
    public static Scene LOGIN_SCENE = register("login");
    public static Scene WELCOME_SCENE = register("welcome");

    public static Scene register(String filename) {
        try {
            // Scene scene = new Scene(FXMLLoader.load(Main.class.getResource("/io/github/Lossttt/athenavox/scenes/" + filename + ".fxml")));
            // scene.getStylesheets().add(Main.class.getResource("styles.css").toExternalForm());
            // return scene;
            return new Scene(FXMLLoader.load(Main.class.getResource(
                "/io/github/Lossttt/athenavox/scenes/" + filename + ".fxml")));
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
