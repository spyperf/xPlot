package com.xplot;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.event.*;
import javafx.application.Application;

public class xPlot extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage mainStage) throws Exception {
        Label label = new Label("oleleolala");
        
        mainStage.setTitle("xPlot");
        mainStage.setScene(new Scene(label, 800, 600));
        mainStage.show();
    }
}