package com.schoolofliberation.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

import com.schoolofliberation.App;
import com.schoolofliberation.entities.ProjectEntity;
import com.schoolofliberation.repositories.ProjectRepository;
import com.schoolofliberation.utils.AlertDialog;
import com.schoolofliberation.utils.Paths;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

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
    private TableColumn<ProjectEntity, String> columnDuration;

    @FXML
    private TableView<ProjectEntity> tableRegister;

    ProjectEntity projectEntity = new ProjectEntity();

    @FXML
    void clickedRegister(MouseEvent event) {
        TableViewSelectionModel<ProjectEntity> selectionModel = tableRegister.getSelectionModel();
        ObservableList<ProjectEntity> selectedItems = selectionModel.getSelectedItems();
        projectEntity = selectedItems.get(0);
    }

    @FXML
    void editRegister(ActionEvent event) {
        try {
            if (Objects.isNull(projectEntity.getId())) {
                AlertDialog.messageWarning("Se debe seleccionar un registro");
            } else {
                App.setRoot(Paths.RUTA_EDITAR, projectEntity);
            }
        } catch (IOException e) {
            AlertDialog.messageError(e.getMessage());
        }
    }

    @FXML
    void newRegister(ActionEvent event) {
        try {
            App.setRoot(Paths.RUTA_PANTALLA, null);
        } catch (IOException e) {
            AlertDialog.messageError(e.getMessage());
        }
    }

    @FXML
    public void initialize() {
        columnName.setCellValueFactory(new PropertyValueFactory<>("projectName"));
        columnPrice.setCellValueFactory(new PropertyValueFactory<>("projectPrice"));
        columnDuration.setCellValueFactory(new PropertyValueFactory<>("time"));
        columnPriceInDollars.setCellValueFactory(new PropertyValueFactory<>("priceOfDollar"));
        columnDate.setCellValueFactory(new PropertyValueFactory<>("createDate"));
        getListProject();
    }

    public void getListProject() {
        ProjectRepository projectRepository = new ProjectRepository();
        for (ProjectEntity projectEntity : projectRepository.findAll()) {
            tableRegister.getItems().add(projectEntity);
        }
    }

}
