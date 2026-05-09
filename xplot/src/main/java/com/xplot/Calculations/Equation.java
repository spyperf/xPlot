package com.xplot.Calculations;
import java.util.*;

public class Equation {
    public Equation() {

    }
    //Math Stuff
    public double solveArithmetic(ArrayList<String> parts) {

        double currentValue = Double.parseDouble(parts.get(0));
        for (int i = 1; i < parts.size(); i+=2) 


        return 0;
    }

    //Parse equation
    public ArrayList<String> equationParts(String equation, int column) {
        ArrayList<String> parts = new ArrayList<String>();
        String currNumber = "";
        for (int i = 0; i < equation.length(); i++) {
            char currChar = equation.charAt(i);
            //Multiple digit numbers should be one part
            if (Character.isDigit(currChar)) {
                currNumber += currChar;
            }
            else {
                //If currNumber is not empty add to list
                if (!currNumber.equals("")) {
                    parts.add(currNumber);
                    currNumber = "";
                }
                //Ignore spaces
                if (currChar != ' ') {
                    parts.add(Character.toString(currChar));
                }
            }
        }
        //Base case
        if (!currNumber.equals("")) {
                parts.add(currNumber);
        }

        System.out.println(parts);
        return parts;
    }

}
