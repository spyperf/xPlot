package com.xplot.Calculations;
import java.util.ArrayList;

public class Function {
    private ArrayList<String> functionsList;

    public Function(ArrayList<String> functionsList) {
        this.functionsList = functionsList;
    }

    public void addToList(String function) {
        functionsList.add(function);
    }

    //public void removeFromList
    public void getFunction(String input) {
        input = input.trim();
        // f(x)
        if (input.length() >= 4 && input.contains("f(x)=")) {
            System.out.println("this works");
        } else {
            System.out.println("6🤷7");
            return;
        }
    }
}
