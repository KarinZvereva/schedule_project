package ru.isu.tashkenova.appSch.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import retrofit2.Response;
import ru.isu.tashkenova.appSch.*;
import javafx.beans.value.ChangeListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class SchemeController {

    WorkloadService service;
    ObservableList<Subject> contentSubject;
    ObservableList<User> contentUsers;
    ObservableList<StudentsClass> contentStudents;

    @FXML
    private GridPaneNew gridpane = new GridPaneNew();

    @FXML
    private Button save;

    @FXML
    private Label img;

    @FXML
    private AnchorPane apane;

    @FXML
    private ChoiceBox classchoice;

    @FXML
    private TableView scheme;

    public String wrong = "#ff5c33";

    public int rows;
    public int cols;

    public void initialize() throws IOException {

        Gson gson = new GsonBuilder()
                .setDateFormat("MMM dd, yyyy")
                .create();

        service = RetrofitService.RetrofitBuildW();

        //получаем все преподаватели
        Response<List<User>> users_s = service.getUsers().execute();
        contentUsers = FXCollections.observableArrayList(
                users_s.body()
        );
        HashMap<Integer, User> users = new HashMap<>();
        for (int i = 0; i < contentUsers.size(); i++) {
            users.put(contentUsers.get(i).getId(), contentUsers.get(i));
        }

        //получаем все предметы
        Response<List<Subject>> subjects_s = service.getSubjects().execute();
        contentSubject = FXCollections.observableArrayList(
                subjects_s.body()
        );
        HashMap<Integer, Subject> subjects = new HashMap<>();
        for (int i = 0; i < contentSubject.size(); i++) {
            subjects.put(contentSubject.get(i).getId(), contentSubject.get(i));
        }

        //получаем все классы
        Response<List<StudentsClass>> stud_s = service.getStudentClasses().execute();
        contentStudents = FXCollections.observableArrayList(
                stud_s.body()
        );
        ArrayList<String> stud = new ArrayList<String>();
        for (StudentsClass s : contentStudents)
            stud.add(s.getCode());
        //выпадающему списку присваеваем значения всех классов
        classchoice.setItems(FXCollections.observableArrayList(stud));

        //все классы
        HashMap<Integer, StudentsClass> students = new HashMap<>();
        for (int i = 0; i < contentStudents.size(); i++) {
            students.put(contentStudents.get(i).getId(), contentStudents.get(i));
        }

        ArrayList<String> time = new ArrayList<String>(Arrays.asList("", "8.00-8.40", "8.50-9.30", "9.40-10.20", "10.40-11.20", "11.40-12.20", "12.30-13.10", "13.20-14.00",
                "14.10-14.50", "15.00-15.40", "16.00-16.40", "17.00-17.40", "17.50-18.30", "18.40-19.20"));

        ArrayList<Workload> workload = new ArrayList<>();
        workload.add(new Workload(1, 1, 9));
        workload.add(new Workload(1, 9, 15));
        workload.add(new Workload(2, 1, 9));
        workload.add(new Workload(2, 9, 15));
        workload.add(new Workload(2, 19, 16));


        ChangeListener<String> changeListener = new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue != null) {
                    System.out.println(newValue);

                    ArrayList<WorkloadView> workloadViews = new ArrayList<>();
                    for (int i = 0; i < workload.size(); i++) {
                        workloadViews.add(new WorkloadView(students.get(workload.get(i).getStudentClassId()),
                                subjects.get(workload.get(i).getSubjectId()), users.get(workload.get(i).getUserId())));
                    }

                    Label labelsScroll[] = new Label[workloadViews.size()];

                    for (int i = 0; i < workloadViews.size(); i++) {
                        labelsScroll[i] = new Label(workloadViews.get(i).toString());
                        labelsScroll[i].setStyle("-fx-background-color:#ccc");
                        labelsScroll[i].setLayoutX(10);
                        labelsScroll[i].setLayoutY(50 * i + 10);
                        labelsScroll[i].setPadding(new Insets(2));
                        apane.getChildren().add(labelsScroll[i]);
                        final int ci = i;

                        labelsScroll[i].setOnDragDetected(new EventHandler<MouseEvent>() {
                            public void handle(MouseEvent event) {

                                System.out.println("onDragDetected");
                                Dragboard db = labelsScroll[ci].startDragAndDrop(TransferMode.ANY);
                                ClipboardContent content = new ClipboardContent();
                                content.putString(labelsScroll[ci].getText());
                                db.setContent(content);

                                event.consume();
                            }
                        });
                    }
                }
            }
        };
        // Selected Item Changed.
        classchoice.getSelectionModel().selectedItemProperty().addListener(changeListener);



        ArrayList<String> a = new ArrayList<String>(Arrays.asList("", "5и", "5м", "6л", "6м", "7а", "7б", "8а", "8б", "8и", "8л", "9а", "9е", "9и", "9л", "9м",
                "9э", "10а", "10е", "10и", "10л", "10м", "11е", "11и", "11л", "11м", "11э"));

        rows = time.size();
        cols = stud.size()+1;
        gridpane.init(cols, rows);

        gridpane.setPadding(new Insets(20));
        gridpane.setGridLinesVisible(true);
        gridpane.setPrefWidth(100 * 26);
        gridpane.setStyle("-fx-background-color:#ffffff");

        LabelNew[][] labels = new LabelNew[time.size() + 1][a.size()];

        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPrefWidth(100);
        columnConstraints.setHalignment(HPos.CENTER);

        labels[0][0] = new LabelNew(a.get(0));
        labels[0][0].setPrefWidth(gridpane.getPrefWidth());
        labels[0][0].setPrefHeight((gridpane.getPrefHeight()));
        labels[0][0].setStyle("-fx-background-color:ffffff;-fx-border-width: 0.5; -fx-border-color: black");
        gridpane.add(labels[0][0], 0, 0);
        labels[0][0].setOnMouseMoved((EventHandler) event -> gridpane.selectRange(0, 0));
        labels[0][0].setId("right");


        for (int i = 1; i < cols; i++) {
            int selectedCol = i;
            labels[0][i] = new LabelNew(stud.get(i-1));
            labels[0][i].setFont(new Font("Arial", 17));
            labels[0][i].setPrefWidth(gridpane.getPrefWidth());
            labels[0][i].setPrefHeight((gridpane.getPrefHeight()));
            labels[0][i].setAlignment(Pos.CENTER);
            labels[0][i].setStyle("-fx-background-color:ffffff;-fx-border-width: 0.5; -fx-border-color: black");
            gridpane.getColumnConstraints().add(columnConstraints);
            gridpane.add(labels[0][i], i, 0);
            labels[0][i].setId("right");
            labels[0][i].setOnMouseMoved((EventHandler) event -> gridpane.selectRange(selectedCol, 0));


        }
        gridpane.getColumnConstraints().add(columnConstraints);

        for (int j = 1; j < rows; j++) {
            int selectedRow = j;
            labels[j][0] = new LabelNew(time.get(j));
            labels[j][0] = new LabelNew("\n" + time.get(j) + "\n");
            gridpane.add(labels[j][0], 0, j);
            labels[j][0].setStyle("-fx-background-color:ffffff;-fx-border-width: 0.5; -fx-border-color:black");
            labels[j][0].setFont(new Font("Arial", 15));
            labels[j][0].setPrefWidth(gridpane.getPrefWidth());
            labels[j][0].setPrefHeight((gridpane.getPrefHeight()));
            labels[j][0].setAlignment(Pos.CENTER);
            labels[j][0].setId("right");
            labels[j][0].setOnMouseMoved((EventHandler) event -> gridpane.selectRange(0, selectedRow));
        }

        for (int i = 1; i < rows; i++)
            for (int j = 1; j < cols; j++) {
                int selectedCol = j;
                int selectedRow = i;

                labels[i][j] = new LabelNew("            \n              \n             ");
                labels[i][j] = new LabelNew("\n\n\n");
                labels[i][j].setFont(new Font("Arial", 11));
                labels[i][j].setPrefHeight(gridpane.getPrefHeight());
                labels[i][j].setPrefWidth(gridpane.getPrefWidth());
                labels[i][j].setAlignment(Pos.CENTER);
                labels[i][j].setStyle("-fx-background-color:#fffff;-fx-border-width: 0.5; -fx-border-color:black");
                gridpane.add(labels[i][j], j, i);
                boolean v = labels[i][j].isValid();
                labels[i][j].setOnMouseMoved((EventHandler) (Event event) -> { gridpane.selectRange(selectedCol, selectedRow); });
                labels[i][j].setId("right");
                final int col = i;
                final int row = j;

                labels[col][row].setOnDragOver(new EventHandler<DragEvent>() {
                    public void handle(DragEvent event) {
                        if (event.getGestureSource() != labels[col][row] &&
                                event.getDragboard().hasString()) {
                            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                        }

                        event.consume();
                    }
                });


                labels[col][row].setOnDragExited(new EventHandler<DragEvent>() {
                    public void handle(DragEvent event) {
                        event.consume();
                    }
                });

                //опустили ячейку в GridPane
                labels[col][row].setOnDragDropped(new EventHandler<DragEvent>() {
                    public void handle(DragEvent event) {

                        System.out.println("onDragDropped");

                        Dragboard db = event.getDragboard();
                        boolean success = false;
                        if (db.hasString()) {
                            labels[col][row].setText(db.getString());
                            labels[col][row].setStyle("-fx-background-color:#fff5c33;-fx-border-width: 0.5; -fx-border-color:black" );
                            labels[col][row].setId("wrong");
                            success = true;
                        }

                        event.setDropCompleted(success);

                        event.consume();
                    }
                });

                //с ячейки убрали
                labels[col][row].setOnDragDone(new EventHandler<DragEvent>() {
                    public void handle(DragEvent event) {

                        System.out.println("onDragDone");

                        if (event.getTransferMode() == TransferMode.MOVE) {
                            labels[col][row].setText("");
                            labels[col][row].setStyle("-fx-background-color: #ffffff;-fx-border-width: 0.5; -fx-border-color:black");
                            labels[col][row].setId("right");
                        }

                        event.consume();
                    }
                });

                //в dridPane
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
    }
    @FXML
    void saveClick(ActionEvent event) {
        Stage stag = (Stage) save.getScene().getWindow();
        stag.close();
    }

}
