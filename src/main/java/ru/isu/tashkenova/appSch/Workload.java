package ru.isu.tashkenova.appSch;

public class Workload {
    public int id;
    public int studentClassId;
    public int subjectId;
    public int userId;
    public int errorCode;

    public Workload(int id, int studentClassId, int subjectId, int userId, int errorCode) {
        this.id = id;
        this.studentClassId = studentClassId;
        this.subjectId = subjectId;
        this.userId = userId;
        this.errorCode = errorCode;
    }

    public Workload(int studentClassId, int subjectId, int userId) {
        this.studentClassId = studentClassId;
        this.subjectId = subjectId;
        this.userId = userId;
    }

    public Workload(){

        this.errorCode = 1;
    }

    public Workload(int errorCode) {
        this.errorCode = 0;
    }

    public int getId() {
        return id;
    }

    public int getStudentClassId() {
        return studentClassId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public int getUserId() {
        return userId;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
