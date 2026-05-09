package com.xplot.Calculations;
import java.util.*;

public class Equation {
    public Equation() {

    }
    public double solveArithmetic(String equation, int column) {
        return 0;
    }

    public ArrayList<String> equationParts(String equation) {
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
