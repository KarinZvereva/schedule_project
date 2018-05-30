package ru.isu.tashkenova.appSch;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CabinetView {
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty name;

    public CabinetView(int id,String name) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public int getId(){
       return id.get();
    }
    public String getName(){
        return name.get();
    }


}
