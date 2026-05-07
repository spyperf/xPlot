package com.xplot.Calculations;
import java.util.ArrayList;

public class Function {
    public void Function(String input, String index, boolean Equation) {
    }

    //public void removeFromList
    public void getFunction(String input) {
        input = input.trim();
        String afterFunction;
        // f(x)
        if (input.length() >= 6 && input.contains("f(x)=")) {
            afterFunction = input.substring(input.indexOf("=") + 1);
            if (afterFunction.length() != 0 && afterFunction.contains("x")) {
                //go to equation class and solve for x
            }
            else if (afterFunction.length() != 0 && !afterFunction.contains("x")) {
                //go to solveMath class and solve the math with  only constants
            }
            else {
                System.out.println("");
                return;
            }  
        }
    }
}
