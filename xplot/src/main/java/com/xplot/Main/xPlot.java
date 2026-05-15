package com.xplot.Main;

import com.xplot.Calculations.Function;
import com.xplot.Calculations.LinearFunction;
import com.xplot.Calculations.Equation;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/* cd "C:\Users\spype\Downloads\xPlot!\xplot"
cd /Users/tommyxu/APCS/xPlot/xplot
mvn clean javafx:run */
public class xPlot extends Application {

    private ArrayList<Function> functionsList = new ArrayList<Function>();
    private Canvas graphCanvas;
    private GraphicsContext gc;

    public ArrayList<Function> getFunctionsList() {
        return functionsList;
    }

    private void addToList(Function function) {
        functionsList.add(function);
    }

    private void removeFromList(Function function) {
        int index = -1;
        for (int i = 0; i < functionsList.size(); i++) {
            if (functionsList.get(i) == function) {
                index = i;
            }
        }
        functionsList.remove(index);
    }

    public void drawFunction(Function function) {
        if (gc == null) {
            return;
        }
        double width = graphCanvas.getWidth();
        double height = graphCanvas.getHeight();
        double centerX = width / 2;
        double centerY = height / 2;
        // Drawing the axis
        // X AXIS
        gc.strokeLine(0, height / 2, width, height / 2);
        // Y AXIS
        gc.strokeLine(width / 2, 0, width / 2, height);
        double pastX = -200;
        // MAYBE USE EVALUATE FORMULA HERE MAKE SURE TO REMEMBER THIS /////////// INSTEAD OF Y = -10
        double pastY = -200;
        for (double newX = -200; newX <= 200; newX += 0.01) {
            // double y = evalute(x); REMEMBER REMEMBER REMEMBER ///////////////
            double newY = newX;
            // CONVERTING FROM PIXEL TO MATH COORDIANTES
            double mathPastX = centerX + pastX;
            double mathPastY = centerY - pastY;
            double mathNewX = centerX + newX;
            double mathNewY = centerY - newY;
            gc.strokeLine(mathPastX, mathPastY, mathNewX, mathNewY);
            pastX = newX;
            pastY = newY;
        }
    }

    public void getFunction(String input) {
        input = input.trim();
        if (input.equals("f(x)=x") || input.equals("y=x")) {
            LinearFunction x = new LinearFunction(input);
            addToList(x);
            drawFunction(x);
        } else {
            return;
        }
    }

    public static void main(String[] args) {
        launch(args);
        Equation equation = new Equation();
        //ArrayList<String> test = equation.equationParts("6+7*6-67");
        //System.out.println(test);
    }

    /*public void extendList() {
        if (!functionsList.get(functionsList.size() - 1).trim().equals("")) {
            functionsList.add("");
        }
    }*/
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
        // GRAPH
        graphCanvas = new Canvas(400, 600);
        // Analogy: Pencil to draw the function
        gc = graphCanvas.getGraphicsContext2D();
        root.getChildren().add(graphCanvas);
        text.setOnAction(event -> {
            String input = text.getText();
            getFunction(input);
        });
        mainStage.show();
    }
}
