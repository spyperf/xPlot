package com.xplot.Main;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/* cd "C:\Users\spype\Downloads\xPlot!\xplot"
mvn clean javafx:run */

public class xPlot extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage mainStage) throws Exception {
        HBox root = new HBox();
        root.setSpacing(30);
        root.getChildren().addAll();
        Label label = new Label("oleleolala");
        TextField text = new TextField();
        //TableView
        mainStage.setTitle("xPlot");
        mainStage.setScene(new Scene(label, 800, 600));
        mainStage.setScene(new Scene(text, 500, 500));
        text.setOnAction(event -> {
            String input = text.getText();
            addToList(input);
            getFunction(input);
        });
        mainStage.show();
    }
}