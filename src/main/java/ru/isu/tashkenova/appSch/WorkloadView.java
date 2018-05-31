package ru.isu.tashkenova.appSch;

public class WorkloadView {

    public StudentsClass studentClass;
    public Subject subject;
    public User user;
    public String time;


    public WorkloadView(StudentsClass studentClass, Subject subject, User user, String time) {
        this.studentClass = studentClass;
        this.subject = subject;
        this.user= user;
        this.time = time;
    }

    public WorkloadView(StudentsClass studentClass, Subject subject, User user) {
        this.studentClass = studentClass;
        this.subject = subject;
        this.user = user;
    }

    public StudentsClass getStudentClass() {
        return studentClass;
    }

    public Subject getSubject() {
        return subject;
    }

    public User getUser() {
        return user;
    }

    public String getTime() {
        return time;
    }

    public void setStudentClass(StudentsClass studentClass) {
        this.studentClass = studentClass;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setUserId(User user) {
        this.user = user;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return subject.getShortName()+"\n"+user.getSurname()+" "+user.getName().substring(0,1) +"."+user.getFathername().substring(0,1);
    }
}
