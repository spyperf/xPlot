package com.xplot.Calculations;

public class LinearFunction extends Function {
    private String function;
    private int x;
    private int y;
    public LinearFunction(String function) {
        this.function = function;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    // If wanting to get values after setting
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    // Solving for x or y
    public int getX(int y) {
        return x;
    }
    public int getY(int x) {
        return y;
    }

}