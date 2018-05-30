package ru.isu.tashkenova.appSch;

public class User {

    private int id;
    private int roleId;
    private String name;
    private String surname;
    private String fathername;
    private String login;
    private String password;
    private int errorCode;

    public User(int id, int roleId, String name, String surname, String fathername, String login,
                String password, int errorCode) {
        this.id = id;
        this.roleId = roleId;
        this.name = name;
        this.surname = surname;
        this.fathername = fathername;
        this.login = login;
        this.password = password;
        this.errorCode = errorCode;
    }

    public User(int roleId, String name, String surname, String fathername, String login) {
        this.roleId = roleId;
        this.name = name;
        this.surname = surname;
        this.fathername = fathername;
        this.login = login;
    }

    public User(int roleId, String name, String surname) {
        this.roleId = roleId;
        this.name = name;
        this.surname = surname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getId() {
        return id;
    }

    public int getRoleId() {
        return roleId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getFathername() {
        return fathername;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public User() {
        this.errorCode = 1;
    }

    public User(int errorCode) {
        this.errorCode = 0;
    }

    @Override
    public String toString() {
        return this.id + "" + this.name + " "+ this.surname +" "+ this.fathername + " " + this.login + " " + this.roleId;
    }
}
