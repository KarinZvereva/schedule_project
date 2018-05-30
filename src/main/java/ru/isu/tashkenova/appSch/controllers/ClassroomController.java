package ru.isu.tashkenova.appSch.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import retrofit2.Response;
import ru.isu.tashkenova.appSch.Cabinet;
import ru.isu.tashkenova.appSch.CabinetView;
import ru.isu.tashkenova.appSch.RetrofitService;
import ru.isu.tashkenova.appSch.UserService;

import java.io.IOException;
import java.util.List;

public class ClassroomController {

    @FXML
    private Button save;

    public static ObservableList<CabinetView> data = FXCollections.observableArrayList();
    UserService service;

    @FXML
    private TableView<CabinetView> tableClassroom = new TableView<>();;

    @FXML
    private TableColumn<CabinetView,Integer>  columnId;

    @FXML
    private TableColumn<CabinetView,String> columnName;

    ObservableList content;

    @FXML
    void initialize() throws IOException {
        columnId.setCellValueFactory(celldata -> celldata.getValue().idProperty().asObject());
        columnName.setCellValueFactory(celldata -> celldata.getValue().nameProperty());

        Gson gson = new GsonBuilder()
                .setDateFormat("MMM dd, yyyy")
                .create();

        service = RetrofitService.RetrofitBuild();

        Response<List<Cabinet>> users = service.getCabinet().execute();
        content = FXCollections.observableArrayList(
                users.body()
        );
        for (Cabinet w: users.body()) {
            Cabinet cabinet = gson.fromJson(gson.toJson(w), Cabinet.class);
            data.add(new CabinetView(cabinet.getId(),cabinet.getName()));
        }
        tableClassroom.setItems(data);
    }

    @FXML
    void addButtonClicked(ActionEvent event) {

    }

    @FXML
    void deleteButtonClicked(ActionEvent event) {

    }

    @FXML
    void saveButtonClicked(ActionEvent event) {
        Stage stag = (Stage) save.getScene().getWindow();
        stag.close();
    }

    @FXML
    void tableClicked(MouseEvent event) {

    }
}
