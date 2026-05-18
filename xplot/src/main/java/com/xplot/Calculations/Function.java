package com.xplot.Calculations;
import java.util.ArrayList;

public class Function {
    // equation to be used in method
    private Equation equation = new Equation();
    public Function() {
    }
    public double evaluateY(String function, double x) {
        // Parts to the equation (using methods in Equation class)
        ArrayList<String> parts = equation.equationParts(function, 0);
        // Scan for x and replacing with value
        for (int i = 0; i < parts.size(); i++) {
            if (parts.get(i).equals("x")) {
                parts.set(i, Double.toString(x));
            }
        }
        // Solving the equation
        return equation.solveArithmetic(parts);
    }
}
