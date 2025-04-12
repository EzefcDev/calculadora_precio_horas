package com.schoolofliberation;

import java.io.IOException;

import com.schoolofliberation.controllers.EditarController;
import com.schoolofliberation.controllers.RegistroController;
import com.schoolofliberation.entities.ProjectEntity;
import com.schoolofliberation.utils.Paths;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    private static Scene scene;
    private static RegistroController registroController;
    private static EditarController editarController;

    @Override
    public void start(Stage stage) throws Exception {
        scene = new Scene(loadFXML(Paths.RUTA_REGISTRO, null));
        stage.setScene(scene);
        stage.setTitle("Precio-Horas");
        stage.show();
    }

    public static void setRoot(String fxml, ProjectEntity projectEntity) throws IOException {
        scene.setRoot(loadFXML(fxml, projectEntity));
    }

    private static Parent loadFXML(String fxml, ProjectEntity projectEntity) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        Parent parent = fxmlLoader.load();
        if (fxml.equals(Paths.RUTA_REGISTRO)) {
            registroController = fxmlLoader.getController();
        } 
        if (fxml.equals(Paths.RUTA_EDITAR)) {
            editarController = fxmlLoader.getController();
            editarController.init(projectEntity);
        } 
        return parent;
    }

    public static RegistroController getRegistroController() {
        return registroController;
    }    

    public static void main(String[] args) {
        launch(args);
    }
}