package ru.isu.tashkenova.appSch;

public class Subject {

    public int id;
    public int groupNumber;
    public String name;
    public String shortName;
    public int errorCode;

    public Subject(int id, int groupNumber, String name, String shortName, int errorCode) {
        this.id = id;
        this.groupNumber = groupNumber;
        this.name = name;
        this.shortName = shortName;
        this.errorCode = errorCode;

    }

    public Subject(){

        this.errorCode = 1;
    }

    public Subject(int errorCode) {
        this.errorCode = 0;
    }

    public int getId() {
        return id;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", groupNumber=" + groupNumber +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", errorCode=" + errorCode +
                '}';
    }
}