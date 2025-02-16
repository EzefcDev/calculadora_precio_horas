package com.schoolofliberation;

import java.io.IOException;

import com.schoolofliberation.controllers.CalculadoraController;
import com.schoolofliberation.controllers.RegistroController;
import com.schoolofliberation.utils.Paths;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    private static Scene scene;
    private static RegistroController registroController;
    private static CalculadoraController calculadoraController;

    @Override
    public void start(Stage stage) throws Exception {
        scene = new Scene(loadFXML(Paths.RUTA_REGISTRO));
        if ("/registro".equals(Paths.RUTA_REGISTRO)) {
            registroController.initialize();
        }
        stage.setScene(scene);
        stage.setTitle("Precio-Horas");
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        Parent parent = fxmlLoader.load();
        if (fxml.equals(Paths.RUTA_REGISTRO)) {
            registroController = fxmlLoader.getController();
        } else {
            calculadoraController = fxmlLoader.getController();
        }
        return parent;
    }

    public static void main(String[] args) {
        launch(args);
    }
}