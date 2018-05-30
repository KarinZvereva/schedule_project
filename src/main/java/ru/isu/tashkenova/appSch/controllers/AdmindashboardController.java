package ru.isu.tashkenova.appSch.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class AdmindashboardController {

    @FXML
    private Label l;

    @FXML
    private Button shedule;

    @FXML
    private Button exit;

    @FXML
    private Button classroom;

    @FXML
    private Button subject;

    @FXML
    private Button users;

    @FXML
    private Button createShedule;

    @FXML
    private TabPane sheduleWeek;

    @FXML
    private Button classes;

    @FXML
    void buttonExitClick(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("views/main.fxml"));
        stage.setTitle("Schedule");
        stage.setScene(new Scene(root, 600, 395));
        stage.show();
        Stage stag = (Stage) exit.getScene().getWindow();
        stag.close();
    }

    @FXML
    void classesClick(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("views/classes.fxml"));
        stage.setTitle("Classes");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.width;
        double height = screenSize.getHeight();
        stage.setScene(new Scene(root, width-1, height-80));
        stage.show();
    }



    @FXML
    void classroomClick(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("views/cabinets.fxml"));
        stage.setTitle("Classes");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.width;
        double height = screenSize.getHeight();
        stage.setScene(new Scene(root, width-1, height-80));
        stage.show();
    }

    @FXML
    void subjectClick(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("views/subjects.fxml"));
        stage.setTitle("Subjects");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.width;
        double height = screenSize.getHeight();
        stage.setScene(new Scene(root, width-1, height-80));
        stage.show();
    }

    @FXML
    void usersClick(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("views/users.fxml"));
        stage.setTitle("Classes");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.width;
        double height = screenSize.getHeight();
        stage.setScene(new Scene(root, width-1, height-80));
        stage.show();
    }

    @FXML
    void createSheduleClick(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("views/createShedule.fxml"));
        stage.setTitle("Create shedule");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.width;
        double height = screenSize.getHeight();
        stage.setScene(new Scene(root, width-10, height-80));
        stage.show();
    }

}
