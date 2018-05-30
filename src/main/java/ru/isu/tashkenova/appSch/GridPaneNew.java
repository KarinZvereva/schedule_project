package ru.isu.tashkenova.appSch;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class GridPaneNew extends GridPane {
    private int cols;
    private int rows;


    public GridPaneNew(){
        this.setOnMouseExited((EventHandler) event -> deselectAll());
    }
    public void init(int cols,int rows){
        getChildren().clear();
        this.cols = cols;
        this.rows = rows;
    }

    private Node getNodeFromGridPane(int col, int row) {
        int c = 0;
        for (Node node : getChildren()) {
          if (c!=0 && GridPaneNew.getColumnIndex(node) == col && GridPaneNew.getRowIndex(node) == row) {
                return node;
            }
            c=1;
        }
        return null;
    }

    private void selectCell(int col, int row, boolean select,boolean main){
        final Node node  = getNodeFromGridPane(col, row);

        if (select){
            if(main){
            node.setStyle("-fx-background-color: #80ccff ;-fx-border-width: 0.5; -fx-border-color: #000000");
            }
            else {
                node.setStyle("-fx-background-color: #ffb366;-fx-border-width: 0.5; -fx-border-color: #000000");
            }
        } else {
            node.setStyle(" -fx-background-color: #ffffff;-fx-border-width: 0.5; -fx-border-color: #000000");
        }
    }

    public void deselectAll(){
        for (int col = 0; col < cols; col++){
            for (int row = 0; row < rows; row++){
                selectCell(col, row, false, false);
            }
        }
    }
    public void selectRange(int selectedCol, int selectedRow){
        deselectAll();
        for (int col = 0; col < cols; col++){
            for (int row = 0; row < rows; row++){
                if(col == selectedCol || row == selectedRow){
                    if(col == selectedCol && row == selectedRow ){
                    selectCell(col, row, true,true);}
                    else{
                        selectCell(col, row, true,false);}
                    }
                }
            }
        }
    }


