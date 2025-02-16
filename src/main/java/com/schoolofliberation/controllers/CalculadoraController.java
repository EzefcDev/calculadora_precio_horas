package com.schoolofliberation.controllers;

import java.io.IOException;

import com.schoolofliberation.App;
import com.schoolofliberation.entities.ProyectEntity;
import com.schoolofliberation.utils.Paths;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class CalculadoraController {

    private RegistroController registroController = new RegistroController();

    @FXML
    private Label messageErrorHour;

    @FXML
    private Label messageErrorPrice;

    @FXML
    private Label messageErrorName;

    @FXML
    private TextField inputHour;

    @FXML
    private TextField inputMinute;

    @FXML
    private TextField inputSecond;

    @FXML
    private TextField priceText;

    @FXML
    private TextField nameText;

    @FXML
    private Label labelHourFull;

    @FXML
    private Label labelPrice;

    @FXML
    private VBox vbox;

    int addHour = 0;
    int addMinute = 0;
    int addSecond = 0;

    ProyectEntity proyectEntity;

    @FXML
    void addTime(ActionEvent event) {
        int hour = inputHour.getText().isBlank() ? 0 : Integer.parseInt(inputHour.getText());
        int minute = inputMinute.getText().isBlank() ? 0 : Integer.parseInt(inputMinute.getText());
        int second = inputSecond.getText().isBlank() ? 0 : Integer.parseInt(inputSecond.getText());
        addHour = addHour + hour;
        addMinute = addMinute + minute;
        addSecond = addSecond + second;
        if (addSecond >= 60) {
            int resultado = addSecond / 60;
            int sobrante = addSecond % 60;
            addMinute = addMinute + resultado;
            addSecond = 0;
            addSecond = addSecond + sobrante;
        }
        if (addMinute >= 60) {
            int resultadoMinute = addMinute / 60;
            int sobranteMinute = addMinute % 60;
            addHour = addHour + resultadoMinute;
            addMinute = 0;
            addMinute = addMinute + sobranteMinute;
        }
        Label label = new Label(hour + ":" + minute + ":" + second);
        vbox.getChildren().add(label);
        cleanInputsTime();
    }

    @FXML
    void calculate(ActionEvent event) {
        if (!priceText.getText().isBlank() && !vbox.getChildren().isEmpty()) {
            if (proyectEntity == null) {
                proyectEntity = new ProyectEntity();
            }
            setMessage();
            int dollar = Integer.parseInt(priceText.getText());
            Double hourFull = (double) addHour;
            Double minuteFull = (double) addMinute;
            Double secondFull = (double) addSecond;
            Double time = hourFull + (minuteFull / 60) + (secondFull / 3600);
            Double price = (dollar * time);
            proyectEntity.setPriceInDollars(dollar);
            proyectEntity.setPriceProyect(price);
            proyectEntity.setTime(time);
            labelPrice.setText("Precio total : $" + price);
            labelHourFull.setText("Horas totales: " + addHour + ":" + addMinute + ":" + addSecond);
        } else {
            setMessage();
        }
    }

    @FXML
    void saveProyect(ActionEvent event) {
        if (!nameText.getText().isBlank() && !priceText.getText().isBlank() && !vbox.getChildren().isEmpty()) {
            if (proyectEntity == null) {
                proyectEntity = new ProyectEntity();
            }
            try {
                proyectEntity.setNameProyect(nameText.getText());
                registroController.addProject(proyectEntity);
                App.setRoot(Paths.RUTA_REGISTRO);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            setMessage();
        }
    }

    @FXML
    void cancel(ActionEvent event) {
        try {
            App.setRoot(Paths.RUTA_REGISTRO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cleanInputsTime() {
        inputHour.setText("");
        inputMinute.setText("");
        inputSecond.setText("");
    }

    private void setMessage() {
        messageErrorPrice.setText(priceText.getText().isBlank() ? "El precio es requerido" : "");
        messageErrorName.setText(
                nameText.getText().isBlank() ? "El nombre del proyecto es requerido para guardar el registro" : "");
        messageErrorHour.setText(vbox.getChildren().isEmpty() ? "Debe ingresar al menos una hora" : "");
    }

}
