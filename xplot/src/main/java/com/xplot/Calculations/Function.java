package com.xplot.Calculations;
import java.util.ArrayList;

public class Function {
    ArrayList<String> functionsList = new ArrayList<String>();
    public Function() {

    }
    public void addToList(String function) {
        functionsList.add(function);
    }
    public void getFunction(String input) {
        input = input.trim();
        // f(x)
        if (input.length() >= 4 && input.contains("f(x)=")) {
            System.out.println("this works");
        }
        else {
            System.out.println("Womp womp");
            return;
        }
    }
}
