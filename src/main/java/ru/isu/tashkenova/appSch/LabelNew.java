package ru.isu.tashkenova.appSch;

import javafx.scene.Node;
import javafx.scene.control.Label;

import java.awt.*;

public class LabelNew extends Label {
    private int cabinetId;
    private int teacherId;
    private boolean isValid;


    public LabelNew() {
    }

    public LabelNew(int cabinetId, int teacherId, boolean isValid) {
        this.cabinetId = cabinetId;
        this.teacherId = teacherId;
        this.isValid = isValid;
    }

    public LabelNew(String text, int cabinetId, int teacherId, boolean isValid) {
        super(text);
        this.cabinetId = cabinetId;
        this.teacherId = teacherId;
        this.isValid = isValid;
    }

    public LabelNew(String text, Node graphic, int cabinetId, int teacherId, boolean isValid) {
        super(text, graphic);
        this.cabinetId = cabinetId;
        this.teacherId = teacherId;
        this.isValid = isValid;
    }

    public LabelNew(int cabinetId, int teacherId) {
        this.cabinetId = cabinetId;
        this.teacherId = teacherId;
        this.isValid = true;
    }

    public LabelNew(String text, int cabinetId, int teacherId) {
        super(text);
        this.cabinetId = cabinetId;
        this.teacherId = teacherId;
        this.isValid = true;
    }

    public LabelNew(String text, Node graphic, int cabinetId, int teacherId) {
        super(text, graphic);
        this.cabinetId = cabinetId;
        this.teacherId = teacherId;
        this.isValid = true;
    }

    public LabelNew(String text) throws HeadlessException {
        super(text);
        this.cabinetId = -1;
        this.teacherId = -1;
        this.isValid = true;
    }


    public int getCabinetId() {
        return cabinetId;
    }

    public void setCabinetId(int cabinetId) {
        this.cabinetId = cabinetId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }
}



