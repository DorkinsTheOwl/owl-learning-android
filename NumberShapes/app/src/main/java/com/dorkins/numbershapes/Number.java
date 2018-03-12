package com.dorkins.numbershapes;

public class Number {
    private int number;

    public Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    private boolean isTriangular() {
        int x = 1;

        int triangularNumber = 1;
        while (triangularNumber < number) {
            x++;
            triangularNumber += x;
        }

        if (triangularNumber == number) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isSquare() {

        double squareRoot = Math.sqrt(number);

        if (squareRoot == Math.floor(squareRoot)) {
            return true;
        } else {
            return false;
        }
    }

    public String checkNumberShape() {
        if (isTriangular() && isSquare()) {
            return "Number is triangular and square";
        } else if (isTriangular()) {
            return "Number is triangular";
        } else if (isSquare()) {
            return "Number is square";
        } else {
            return "Number is neither triangular nor square";
        }
    }
}
