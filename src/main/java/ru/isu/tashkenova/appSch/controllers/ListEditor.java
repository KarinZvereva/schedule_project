package ru.isu.tashkenova.appSch.controllers;

import javafx.event.ActionEvent;

import java.io.IOException;

public interface ListEditor {
    void saveButtonClicked(ActionEvent actionEvent);
    void deleteButtonClicked(ActionEvent actionEvent) throws IOException;
    void addButtonClicked(ActionEvent actionEvent) throws IOException, Exception;
    void initialize() throws IOException;
}
