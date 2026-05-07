package com.xplot.Main;
import  com.xplot.Calculations.Function;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;



/* cd "C:\Users\spype\Downloads\xPlot!\xplot"
Users/tommyxu/APCS/xPlot/xplot
mvn clean javafx:run */ 



public class xPlot extends Application {

    private ArrayList<String> functionsList = new ArrayList<String>();
    public ArrayList<String> getFunctionsList() {
        return functionsList;
    }

    private void addToList(String function) {
        functionsList.add(function);
    }
    private void removeFromList(String function) {
        int index = -1;
        for (int i = 0; i < functionsList.size(); i++) {
            if (functionsList.get(i) == function) {
                index = i;
            }
        }
        functionsList.remove(index);
    }

    private void getFunction(String function) {
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void extendList() {
        if (!functionsList.get(functionsList.size()-1).trim().equals(""));
        functionsList.add("");
    }

    @Override
    public void start(Stage mainStage) throws Exception {
        HBox root = new HBox();
        root.setSpacing(30);
        TextField text = new TextField();
        root.getChildren().addAll(text);
        //TableView
        TableView functionTable = new TableView<String>();
        TableColumn functionColumn = new TableColumn<Function, String>("Functions");
        root.getChildren().addAll(functionTable);
        

        mainStage.setTitle("xPlot");
        mainStage.setScene(new Scene(root, 800, 600));
        text.setOnAction(event -> {
            String input = text.getText();
            addToList(input);
            getFunction(input);
        });
        mainStage.show();
    }
}