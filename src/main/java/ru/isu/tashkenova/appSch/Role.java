package ru.isu.tashkenova.appSch;

public class Role {
    public int id;
    public String name;
    public int errorCode;


    public Role(int id, String name, int errorCode) {
        this.id = id;
        this.name = name;
        this.errorCode = errorCode;
    }

    public Role() {
        this.errorCode = 1;
    }

    public Role(int errorCode) {
        this.errorCode = 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", errorCode=" + errorCode +
                '}';
    }
}


