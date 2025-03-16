package com.schoolofliberation.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import com.schoolofliberation.App;
import com.schoolofliberation.entities.ProjectEntity;
import com.schoolofliberation.services.ProjectService;
import com.schoolofliberation.utils.Paths;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class RegistroController {

    @FXML
    private TableColumn<ProjectEntity, LocalDate> columnDate;

    @FXML
    private TableColumn<ProjectEntity, String> columnName;

    @FXML
    private TableColumn<ProjectEntity, Double> columnPrice;

    @FXML
    private TableColumn<ProjectEntity, Integer> columnPriceInDollars;

    @FXML
    private TableColumn<ProjectEntity, Double> columnDuration;

    @FXML
    private TableView<ProjectEntity> tableRegister;

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
        columnPriceInDollars.setCellValueFactory(new PropertyValueFactory<>("priceInDollars"));
        columnDate.setCellValueFactory(new PropertyValueFactory<>("createDate"));
        getListProject();
    }

    public void getListProject() {
        List<ProjectEntity> projectEntities = ProjectService.getAllProjectEntity();
        for (ProjectEntity projectEntity : projectEntities) {
            tableRegister.getItems().add(projectEntity);
        }
    }

}
