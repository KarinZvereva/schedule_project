package ru.isu.tashkenova.appSch.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ru.isu.tashkenova.appSch.GridPaneNew;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class SchemeController {

   /* WorkloadService service;
    ObservableList<Subject> contentSubject;
    ObservableList<User> contentUsers;
    ObservableList<StudentsClass> contentStudents;*/

    @FXML
    private GridPaneNew gridpane = new GridPaneNew();

    @FXML
    private Button save;

    @FXML
    private Label img;

    @FXML
    private TableView scheme;

    @FXML
    private Label l1;

    @FXML
    private Label l2;

    private int x = 1;
    private int y = 1;

    public int rows;
    public int cols;


    public void initialize() throws IOException {


        l1.setText("Литература \nБурзунова Г. Е.");
        ArrayList<String> a = new ArrayList<String>(Arrays.asList("","5и","5м", "6л", "6м", "7а", "7б", "8а", "8б", "8и", "8л", "9а", "9е", "9и", "9л", "9м",
                "9э", "10а", "10е", "10и", "10л", "10м", "11е", "11и", "11л", "11м", "11э"));
        ArrayList<String> time = new ArrayList<String>(Arrays.asList("","8.00-8.40", "8.50-9.30", "9.40-10.20", "10.40-11.20", "11.40-12.20", "12.30-13.10", "13.20-14.00",
                "14.10-14.50","15.00-15.40","16.00-16.40", "17.00-17.40", "17.50-18.30", "18.40-19.20"));
        rows = time.size();
        cols = a.size() ;
        gridpane.init(cols,rows);

        gridpane.setPadding(new Insets(20));
        gridpane.setGridLinesVisible(true);
        gridpane.setPrefWidth(100*26);
        gridpane.setStyle(" -fx-background-color: #ffffff");

        Label[][] labels = new Label[time.size()+1][a.size()];

        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPrefWidth(100);
        columnConstraints.setHalignment(HPos.CENTER);

        labels[0][0] = new Label(a.get(0));
        labels[0][0].setPrefWidth(gridpane.getPrefWidth());
        labels[0][0].setPrefHeight((gridpane.getPrefHeight()));
        labels[0][0].setStyle("#ffffff;-fx-border-width: 0.5; -fx-border-color: #000000");
        gridpane.add( labels[0][0], 0, 0);
        labels[0][0].setOnMouseMoved((EventHandler) event -> gridpane.selectRange(0, 0));


        for(int i = 1; i<a.size(); i++) {
            int selectedCol = i;
            labels[0][i] = new Label(a.get(i));
            labels[0][i].setFont(new Font("Arial", 17));
            labels[0][i].setPrefWidth(gridpane.getPrefWidth());
            labels[0][i].setPrefHeight((gridpane.getPrefHeight()));
            labels[0][i].setAlignment(Pos.CENTER);
            labels[0][i].setStyle("-fx-border-width: 0.5; -fx-border-color: #000000");
            gridpane.getColumnConstraints().add(columnConstraints);
            gridpane.add(labels[0][i], i, 0);

            labels[0][i].setOnMouseMoved((EventHandler) event -> gridpane.selectRange(selectedCol, 0));



        }
        gridpane.getColumnConstraints().add(columnConstraints);

        for (int j=1; j<time.size(); j++) {
            int selectedRow = j;
            labels[j][0] = new Label(time.get(j));
            labels[j][0] = new Label("\n"+time.get(j)+"\n");
            gridpane.add(labels[j][0],0,j);
            labels[j][0].setStyle("-fx-border-width: 0.5; -fx-border-color:#000000");
            labels[j][0].setFont(new Font("Arial", 15));
            labels[j][0].setPrefWidth(gridpane.getPrefWidth());
            labels[j][0].setPrefHeight((gridpane.getPrefHeight()));
            labels[j][0].setAlignment(Pos.CENTER);

            labels[j][0].setOnMouseMoved((EventHandler) event -> gridpane.selectRange(0,selectedRow));
        }

        for(int i = 1; i<time.size(); i++)
            for (int j=1; j<a.size(); j++) {
            int selectedCol = j;
            int selectedRow = i;
                labels[i][j] = new Label("            \n              \n             ");
                labels[i][j] = new Label("\n\n\n");
                labels[i][j].setFont(new Font("Arial", 11));
                labels[i][j].setPrefHeight(gridpane.getPrefHeight());
                labels[i][j].setPrefWidth(gridpane.getPrefWidth());
                labels[i][j].setAlignment(Pos.CENTER);
                labels[i][j].setStyle("-fx-border-width: 0.5; -fx-border-color: #000000");
                gridpane.add( labels[i][j],j,i);

                labels[i][j].setOnMouseMoved((EventHandler) event -> gridpane.selectRange(selectedCol, selectedRow));

                final int col = i;
                final int row = j;

                labels[col][row].setOnDragOver(new EventHandler <DragEvent>() {
                    public void handle(DragEvent event) {
                        if (event.getGestureSource() !=  labels[col][row] &&
                                event.getDragboard().hasString()) {
                            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                        }

                        event.consume();
                    }
                });


                labels[col][row].setOnDragExited(new EventHandler <DragEvent>() {
                    public void handle(DragEvent event) {
                        event.consume();
                    }
                });

                labels[col][row].setOnDragDropped(new EventHandler <DragEvent>() {
                    public void handle(DragEvent event) {

                        System.out.println("onDragDropped");

                        Dragboard db = event.getDragboard();
                        boolean success = false;
                        if (db.hasString()) {
                            labels[col][row].setText(db.getString());
                            labels[col][row].setStyle("-fx-background-color:#ccc");
                            success = true;
                        }

                        event.setDropCompleted(success);

                        event.consume();
                    }
                });

                labels[col][row].setOnDragDone(new EventHandler <DragEvent>() {
                    public void handle(DragEvent event) {

                        System.out.println("onDragDone");

                        if (event.getTransferMode() == TransferMode.MOVE) {
                            labels[col][row].setText("");
                            labels[col][row].setStyle("-fx-background-color:#fff");
                        }

                        event.consume();
                    }
                });

                labels[col][row].setOnDragDetected(new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent event) {

                        System.out.println("onDragDetected");
                        Dragboard db = labels[col][row].startDragAndDrop(TransferMode.ANY);
                        ClipboardContent content = new ClipboardContent();
                        content.putString(labels[col][row].getText());
                        db.setContent(content);

                        event.consume();
                    }
                });
            }


        l1.setOnDragDetected(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {

                System.out.println("onDragDetected");
                Dragboard db = l1.startDragAndDrop(TransferMode.ANY);
                ClipboardContent content = new ClipboardContent();
                content.putString(l1.getText());
                db.setContent(content);

                event.consume();
            }
        });

    }
    @FXML
    void saveClick(ActionEvent event) {
        Stage stag = (Stage) save.getScene().getWindow();
        stag.close();
    }

}
