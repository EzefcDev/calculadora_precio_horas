package com.schoolofliberation.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class AlertDialog  {

    public static void messageError(final String message) {
        Alert messageErrror = new Alert(AlertType.ERROR);
        messageErrror.setTitle("Dialogo de error");
        messageErrror.setContentText("Ocurrio un error");

        Label label = new Label("El error es el siguiente: ");
        TextArea textArea = new TextArea(message);
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);
        GridPane content = new GridPane();
        content.setMaxWidth(Double.MAX_VALUE);
        content.add(label, 0, 0);
        content.add(textArea, 0, 1);

        messageErrror.getDialogPane().setExpandableContent(content);
        messageErrror.showAndWait();
    }

    public static void messageWarning(final String message) {
        Alert menssage = new Alert(AlertType.WARNING);
        menssage.setTitle("Advertencia");
        menssage.setContentText(message);
        menssage.showAndWait();
    }
}
