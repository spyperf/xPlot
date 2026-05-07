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
        if (input.length() >= 6 && input.contains("f(x)=")) {
            if (input.contains("f(x)=x")) {

            }
            else if (input.contains("f(x)=x^2")) {

            }
            else if (input.contains("f(x)=x^3")) {

            }
            else {
                
            }
        } else {
            System.out.println("");
            return;
        }
    }
}
