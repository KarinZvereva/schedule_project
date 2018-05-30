package ru.isu.tashkenova.appSch.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import retrofit2.Response;
import ru.isu.tashkenova.appSch.*;

import java.io.IOException;
import java.util.List;

public class UsersController implements ListEditor{

    public static ObservableList<UserView> data = FXCollections.observableArrayList();
    UserService service;
    ObservableList<Role> content;


    @FXML
    private TableView<UserView> usersTable = new TableView<>();

    @FXML
    private TableColumn<UserView, String> columnName;

    @FXML
    private TableColumn<UserView, String> columnSurname;

    @FXML
    private TableColumn<UserView, String> columnfatherrname;

    @FXML
    private TableColumn<UserView, String> columnRoleId;

    @FXML
    private TableColumn<UserView, String> columnlogin;

    @FXML
    private Label name;




    @Override
    public void saveButtonClicked(ActionEvent actionEvent) {

    }


    @Override
    public void initialize() throws IOException {

        Gson gson = new GsonBuilder()
                .setDateFormat("MMM dd, yyyy")
                .create();

        service = RetrofitService.RetrofitBuild();

        columnName.setCellValueFactory(celldata -> celldata.getValue().nameProperty());
        columnSurname.setCellValueFactory(celldata -> celldata.getValue().lastnameProperty());
        columnRoleId.setCellValueFactory(celldata -> celldata.getValue().roleProperty());
        columnfatherrname.setCellValueFactory(celldata -> celldata.getValue().fathernameProperty());
        columnlogin.setCellValueFactory(celldata -> celldata.getValue().loginProperty());

        Response<List<Role>> roles = service.getRole().execute();
         content = FXCollections.observableArrayList(
                roles.body()
        );


        Response<List<User>> users = service.getUsers().execute();


        for (User w: users.body()) {
            User user = gson.fromJson(gson.toJson(w), User.class);
            data.add(new UserView(user.getName(), user.getSurname(),
                    user.getFathername(), user.getLogin(), user.getRoleId(), content.get(user.getRoleId()).name, user.getId(), user.getPassword()));


        }
        usersTable.setItems(data);

        usersTable.setOnMouseClicked(new ListViewHandler(){
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                UserView user = usersTable.getSelectionModel().getSelectedItem();
            }
        });
    }


    @FXML
    @Override
    public void deleteButtonClicked(ActionEvent event) throws IOException {
        UserView user = usersTable.getSelectionModel().getSelectedItem();
        service.deleteUser(user.getId()).execute();
        data.remove(usersTable.getSelectionModel().getSelectedIndex());
        usersTable.refresh();
    }

    @Override
    public void addButtonClicked(ActionEvent actionEvent) throws Exception {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("views/add_user.fxml"));
        Parent root_add = fxmlLoader.load();
        AddUserController c = fxmlLoader.getController();
        c.setChoiseBox(content);
        stage.setTitle("Добавить пользователя");
        stage.setScene(new Scene(root_add, 456, 439));
        stage.show();
        usersTable.refresh();

    }

    public void changeButtonClicked(ActionEvent actionEvent) throws IOException {
        UserView user = usersTable.getSelectionModel().getSelectedItem();
        Stage stage_add = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("views/change_user.fxml"));
        Parent root_add = fxmlLoader.load();
        ChangeUserController c = fxmlLoader.getController();
        c.setUserv(user, usersTable.getSelectionModel().getSelectedIndex(), content);
        stage_add.setTitle("Изменить пользователя");
        stage_add.setScene(new Scene(root_add, 456, 439));
        stage_add.show();
        usersTable.refresh();
    }


    class ListViewHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            //this method will be overrided in next step
        }
    }


}


