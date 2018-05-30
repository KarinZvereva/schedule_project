package ru.isu.tashkenova.appSch;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;

public class UserView {

    private final SimpleStringProperty name;
    private final SimpleStringProperty lastname;
    private final SimpleStringProperty fathername;
    private final SimpleStringProperty login;
    private final SimpleStringProperty role;
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty password;
    private int roleId;


    public UserView(String name, String lastname, String fathername, String login, Integer roleId, String role,
                    Integer id, String password) throws IOException {

        this.name = new SimpleStringProperty(name);
        this.lastname = new SimpleStringProperty(lastname);
        this.fathername = new SimpleStringProperty(fathername);
        this.login = new SimpleStringProperty(login);
        this.role = new SimpleStringProperty(role);
        this.id = new SimpleIntegerProperty(id);
        this.password = new SimpleStringProperty(password);
        this.roleId = roleId;
        //this.content = content;
    }


    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public String getLastname() {
        return lastname.get();
    }

    public SimpleStringProperty lastnameProperty() {
        return lastname;
    }

    public String getFathername() {
        return fathername.get();
    }

    public SimpleStringProperty fathernameProperty() {
        return fathername;
    }

    public String getLogin() {
        return login.get();
    }

    public SimpleStringProperty loginProperty() {
        return login;
    }

    public String getRole() {
        return role.get();
    }

    public SimpleStringProperty roleProperty() {
        return role;
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setLastname(String lastname) {
        this.lastname.set(lastname);
    }

    public void setFathername(String fathername) {
        this.fathername.set(fathername);
    }

    public void setLogin(String login) {
        this.login.set(login);
    }

    public void setRole(String role) {
        this.role.set(role);
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserView{" +
                "name=" + name +
                ", lastname=" + lastname +
                ", fathername=" + fathername +
                ", login=" + login +
                ", roleId=" + roleId +
                ", id=" + id +
                '}';
    }
}
