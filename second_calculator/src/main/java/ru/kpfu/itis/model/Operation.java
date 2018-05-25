package ru.kpfu.itis.model;

public class Operation {

    public static double calc(String operation, double a, double b) {

        if (operation.equals("/")){ return a / b; }

        else if (operation.equals("*")) { return a * b; }

        else if (operation.equals("-")) { return a - b; }

        else if (operation.equals("+")) { return a + b; }

        else return 0f;
    }
}
