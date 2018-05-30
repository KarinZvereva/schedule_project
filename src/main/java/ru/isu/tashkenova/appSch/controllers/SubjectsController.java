package ru.isu.tashkenova.appSch.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class SubjectsController  implements ListEditor{
    @FXML
    private TableView<?> subjects;

    @FXML
    private Button save;


    @Override
    public void saveButtonClicked(ActionEvent actionEvent) {
        Stage stag = (Stage) save.getScene().getWindow();
        stag.close();
    }

    @Override
    public void deleteButtonClicked(ActionEvent actionEvent) throws IOException {

    }

    @Override
    public void addButtonClicked(ActionEvent actionEvent) throws IOException, Exception {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("views/addSubject.fxml"));
        stage.setTitle("Add subject");
        stage.setScene(new Scene(root, 449, 423));
        stage.show();
    }

    @Override
    public void initialize() throws IOException {

    }
}
