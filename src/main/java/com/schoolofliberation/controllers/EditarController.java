package com.schoolofliberation.controllers;

import java.io.IOException;

import com.schoolofliberation.App;
import com.schoolofliberation.entities.ProjectEntity;
import com.schoolofliberation.services.ProjectService;
import com.schoolofliberation.utils.AlertDialog;
import com.schoolofliberation.utils.Paths;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EditarController {

    @FXML
    private Label labelHourFull;

    @FXML
    private Label labelProjectName;

    @FXML
    private Label labelTotalPrice;

    @FXML
    private Label messageErrorPrice;

    @FXML
    private TextField priceText;

    ProjectEntity projectEntityUpdate;

    Double time;

    int dollar;
    Double price;

    @FXML
    void calculate(ActionEvent event) {
        if (!priceText.getText().isBlank()) {
            dollar = Integer.parseInt(priceText.getText());
            price = (dollar * time);
            labelTotalPrice.setText("Precio total: " + price);
        } else {
            messageErrorPrice.setText(priceText.getText().isBlank() ? "El valor del dolar es requerido" : "");
        }
    }

    @FXML
    void cancel(ActionEvent event) {
        try {
            App.setRoot(Paths.RUTA_REGISTRO, null);
        } catch (IOException e) {
            AlertDialog.messageError(e.getMessage());
        }
    }

    @FXML
    void saveProyect(ActionEvent event) {
        try {
            projectEntityUpdate.setPriceOfDollar(dollar);
            projectEntityUpdate.setProjectPrice(price);
            ProjectService.updateProjectEntity(projectEntityUpdate);
            App.setRoot(Paths.RUTA_REGISTRO, null);
        } catch (Exception e) {
            AlertDialog.messageError(e.getMessage());
        }
    }

    public void init(ProjectEntity projectEntity) {
        projectEntityUpdate = projectEntity;
        labelProjectName.setText(projectEntity.getProjectName());
        labelHourFull.setText(String.valueOf(projectEntity.getTime()));
        time = projectEntity.getTimeInDouble();
    }

}
