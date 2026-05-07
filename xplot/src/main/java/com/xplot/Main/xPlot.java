package com.xplot.Main;
import  com.xplot.Calculations.Function;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/* cd "C:\Users\spype\Downloads\xPlot!\xplot"
mvn clean javafx:run */
public class xPlot extends Application {

    private ArrayList<String> functionsList = new ArrayList<String>();

    public ArrayList<String> getFunctionsList() {
        return functionsList;
    }

    private void addToList(String function) {
        functionsList.add(function);
    }

    private void getFunction(String function) {
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage mainStage) throws Exception {
        Function function = new Function(functionsList);
        HBox root = new HBox();
        root.setSpacing(30);
        TextField text = new TextField();
        root.getChildren().addAll(text);
        //TableView
        mainStage.setTitle("xPlot");
        mainStage.setScene(new Scene(root, 800, 600));
        text.setOnAction(event -> {
            String input = text.getText();
            function.addToList(input);
            function.getFunction(input);
        });
        mainStage.show();
    }
}