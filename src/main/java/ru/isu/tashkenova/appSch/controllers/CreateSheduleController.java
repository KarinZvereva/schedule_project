package ru.isu.tashkenova.appSch.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class CreateSheduleController {
    @FXML
    private ComboBox<?> day;

    @FXML
    private Button createScheme;

    @FXML
    private TableView<?> scheme;

    @FXML
    private Button changeScheme;

    @FXML
    private Button deleteScheme;



    @FXML
    void changeSchemeClick(ActionEvent event) {

    }

    @FXML
    void createSchemeClick(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("views/rasp.fxml"));
        stage.setTitle("Classes");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.width;
        double height = screenSize.getHeight();
        stage.setScene(new Scene(root, width-1, height-80));
        stage.show();
    }

    @FXML
    void dayClick(ActionEvent event) {

    }

    @FXML
    void deleteSchemeClick(ActionEvent event) {

    }
}
