package ru.isu.tashkenova.appSch.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ru.isu.tashkenova.appSch.RetrofitService;
import ru.isu.tashkenova.appSch.Role;
import ru.isu.tashkenova.appSch.User;
import ru.isu.tashkenova.appSch.UserView;

import java.io.IOException;
import java.util.ArrayList;

public class ChangeUserController  {
    @FXML
    private Label cname;

    @FXML
    private TextField ctname;

    @FXML
    private TextField ctsurname;

    @FXML
    private TextField ctfathername;

    @FXML
    private ChoiceBox ctroleId;

    @FXML
    private TextField ctlogin;

    @FXML
    private TextField ctpassword;


    UserView userv;
    User user = new User();
    int id;
    ArrayList<String> s = new ArrayList<>();

    public void setUserv(UserView userv, int id, ObservableList<Role> l) {

        for (Role role:l) {
            s.add(role.name);
        }

        ctroleId.setItems(FXCollections.observableArrayList(s));
        this.userv = userv;
        ctname.setText(userv.getName());
        ctsurname.setText(userv.getLastname());
        ctfathername.setText(userv.getFathername());
        ctroleId.setValue(userv.getRole());
        ctlogin.setText(userv.getLogin());
        ctpassword.setText(userv.getPassword());
        this.id = id;

    }

    public void initialize() {

    }

    public void saveButtonClicked(ActionEvent actionEvent) throws IOException {
        String user_name = ctname.getText();
        String user_surname = ctsurname.getText();
        String user_fathername = ctfathername.getText();
        int user_roleId = 2;
        String user_rolename = String.valueOf(ctroleId.getValue());

        try {
            user_roleId = s.indexOf(ctroleId.getValue());
        }

        catch (Exception e) {
            user_roleId = 2;
        }

        String user_login = ctlogin.getText();
        String user_password = ctpassword.getText();


        user = new User(0,user_roleId,user_name,user_surname,
                user_fathername, user_login, user_password, 1);


        RetrofitService.RetrofitBuild().putUser(userv.getId(), user).execute();
        UsersController.data.set(id,new UserView(user.getName(), user.getSurname(),
                user.getFathername(), user.getLogin(), user.getRoleId(), user_rolename, user.getId(), user.getPassword()));


        cname.getScene().getWindow().hide();

    }
}
