package ru.isu.tashkenova.appSch.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ClassesController {
    @FXML
    private Button add;

    @FXML
    private Label i5;

    @FXML
    private Label im;

    @FXML
    private Label l6;

    @FXML
    private Label m6;

    @FXML
    void addButtonClicked(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        String s = "Add class";
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("views/addClass.fxml"));
        stage.setTitle(s);
        stage.setScene(new Scene(root, 407, 421));
        stage.show();
    }

    @FXML
    void labelClassEntered(MouseEvent mouseEvent) {
        Label l = (Label)mouseEvent.getTarget();
        l.setUnderline(true);
    }

    @FXML
    void labelClassExited(MouseEvent mouseEvent) {
        Label l = (Label)mouseEvent.getTarget();
        l.setUnderline(false);
    }

    @FXML
    void labelClassesClicked(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        String s = "Class Editor";
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("views/classEditor.fxml"));
        stage.setTitle(s);
        stage.setScene(new Scene(root, 1031, 791));
        stage.show();
    }
}
