package com.xplot.Calculations;
import java.util.*;

public class Equation {
    public Equation() {

    }
    //Math Stuff
    public double solveArithmetic(ArrayList<String> parts) {

        double answer= Double.parseDouble(parts.get(0));
        //First pass, check for multiplication and division
        for (int i = 1; i < parts.size(); i+=2) {
            
        }
        return answer;
    }

    //Parse equation
    public ArrayList<String> equationParts(String equation, int column) {
        ArrayList<String> parts = new ArrayList<String>();
        String currNumber = "";
        String currString = "";
        for (int i = 0; i < equation.length(); i++) {
            char currChar = equation.charAt(i);

            //Check for negative sign instead of operator: subtraction
            //The cases it is it negative sign instead of a subtraction sign are:
            //1. '-' is the first character
            //2. '-' is after an operator
            //3. '-' is after an open parenthesis/bracket
            if (currChar == '-' && (i == 0 || equation.charAt(i-1) == '+' ||
                equation.charAt(i-1) == '-' || equation.charAt(i-1) == '*' ||
                equation.charAt(i-1) == '/' || equation.charAt(i-1) == '(')
            ) {
                //Letter vs number
                if (Character.isLetter(equation.charAt(i+1))) {
                    currString += currChar;
                } else {
                    currNumber += currChar;
                }
            }

            //Multiple digit numbers should be one part
            if (Character.isDigit(currChar) || currChar == '.') {
                currNumber += currChar;
            }
            //Multiple letters should be together to form something like "sqrt"
            else if (Character.isLetter(currChar)) {
                currString += currChar;
            }
            else {
                //If currNumber is not empty add to list
                if (!currNumber.equals("")) {
                    parts.add(currNumber);
                    currNumber = "";
                }
                if (!currString.equals("")) {
                    parts.add(currString);
                    currString = "";
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
        if (!currString.equals("")) {
            parts.add(currString);
        }

        System.out.println(parts);
        return parts;
    }

}
