package ru.isu.tashkenova.appSch;

public class Cabinet {
    public int id;
    public String name;

    public Cabinet(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }


}
