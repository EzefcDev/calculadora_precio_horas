package com.schoolofliberation.controllers;

import java.io.IOException;
import java.time.LocalDate;

import com.schoolofliberation.App;
import com.schoolofliberation.entities.ProyectEntity;
import com.schoolofliberation.utils.Paths;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class RegistroController {

    @FXML
    private TableColumn<ProyectEntity, LocalDate> columnDate;

    @FXML
    private TableColumn<ProyectEntity, String> columnName;

    @FXML
    private TableColumn<ProyectEntity, Double> columnPrice;

    @FXML
    private TableColumn<ProyectEntity, Integer> columnPriceInDollars;

    @FXML
    private TableColumn<ProyectEntity, Double> columnDuration;

    @FXML
    private TableView<ProyectEntity> tableRegister;

    @FXML
    void newRegister(ActionEvent event) {
        try {
            App.setRoot(Paths.RUTA_PANTALLA);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        columnName.setCellValueFactory(new PropertyValueFactory<>("nameProyect"));
        columnPrice.setCellValueFactory(new PropertyValueFactory<>("priceProyect"));
        columnDuration.setCellValueFactory(new PropertyValueFactory<>("time"));
        columnPriceInDollars.setCellValueFactory(new PropertyValueFactory<>("dollarPrice"));
        columnDate.setCellValueFactory(new PropertyValueFactory<>("createDate"));
    }

    public void addProject(ProyectEntity projectEntity) {
        tableRegister.getItems().add(projectEntity);
    }

}
