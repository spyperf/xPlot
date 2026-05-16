package com.xplot.Calculations;
import java.util.*;

public class Equation {
    public Equation() {

    }
    //Math Stuff
    public double solveArithmetic(ArrayList<String> parts) {

        //First pass, check for parentheses
        for (int i = 0; i < parts.size(); i++) {
            //Find the first close parenthesis
            if (parts.get(i).equals(")")) {
                int closeLocation = i;
                int openLocation = 0;

                //Find the last close parenthesis before the close parenthesis
                for (int j = 0; j < parts.size(); j++) {
                    if (parts.get(j).equals("(") && j < i) {
                        openLocation = j;
                    }
                }

                //Solve everything inside the parentheses
                ArrayList<String> insideParentheses = new ArrayList<String>();
                for (int k = openLocation + 1; k < closeLocation; k++) {
                    insideParentheses.add(parts.get(k));
                }
                double insideAnswer = solveArithmetic(insideParentheses);

                //Remove all stuff inside the parentheses from the original parts arraylist
                for (int k = openLocation; k <= closeLocation; k++) {
                    parts.remove(openLocation);
                }

                //Add the inside answer back
                parts.add(openLocation, Double.toString(insideAnswer));

                //Reset i
                i=-1;
            }
        }

        double answer = Double.parseDouble(parts.get(0));
        //Second pass, check for exponent
        for (int i = 1; i < parts.size(); i+=2) {
            String mathSymbol = parts.get(i);
            if (mathSymbol.equals("^")) {
                double leftNum = Double.parseDouble(parts.get(i-1));
                double rightNum = Double.parseDouble(parts.get(i+1));
                
                answer = Math.pow(leftNum, rightNum);

                parts.remove(i-1);
                parts.remove(i-1);
                parts.remove(i-1);
                parts.add(i-1,Double.toString(answer));

                i-=2;
            }
        }

        answer = Double.parseDouble(parts.get(0));
        //Third pass, check for multiplication and division
        for (int i = 1; i < parts.size(); i+=2) {
            String mathSymbol = parts.get(i);
            if (mathSymbol.equals("*") || mathSymbol.equals("/")) {
                double leftNum = Double.parseDouble(parts.get(i-1));
                double rightNum = Double.parseDouble(parts.get(i+1));
                if (mathSymbol.equals("*")) {
                    answer = leftNum * rightNum;
                }
                else if (mathSymbol.equals("/")) {

                    //Cannot divide by zero
                    if (rightNum == 0) {
                        System.out.println("Cannot divide by 0"); //This will need to be changed into an alert pop-up panel
                        return 0;
                    }

                    answer = leftNum / rightNum;
                }
                parts.remove(i-1);
                parts.remove(i-1);
                parts.remove(i-1);
                parts.add(i-1,Double.toString(answer));

                i-=2;
            }
        }

        answer = Double.parseDouble(parts.get(0));
        //Fourth Pass, check for addition and subtraction
        for (int i = 1; i < parts.size(); i+=2) {
            String mathSymbol = parts.get(i);
            if (mathSymbol.equals("+") || mathSymbol.equals("-")) {
                double leftNum = Double.parseDouble(parts.get(i-1));
                double rightNum = Double.parseDouble(parts.get(i+1));
                if (mathSymbol.equals("+")) {
                    answer = leftNum + rightNum;
                }
                else if (mathSymbol.equals("-")) {
                    answer = leftNum - rightNum;
                }
                parts.remove(i-1);
                parts.remove(i-1);
                parts.remove(i-1);
                parts.add(i-1,Double.toString(answer));
                i-=2;
            }
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

            //Check for negative sign instead of symbol: subtraction
            //The cases it is it negative sign instead of a subtraction sign are:
            //1. '-' is the first character
            //2. '-' is after an symbol
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
