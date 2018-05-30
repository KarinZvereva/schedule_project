package ru.isu.tashkenova.appSch.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AddSubjectController {

    @FXML
    private Button save;

    @FXML
    private Label emptyName;

    @FXML
    private Label emptySokr;

    @FXML
    private Label emptyGroups;

    @FXML
    void saveClick(ActionEvent event) {
        Stage stag = (Stage) save.getScene().getWindow();
        stag.close();
    }
}
