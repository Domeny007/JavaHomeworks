package ru.kpfu.itis.model;

public class Result {

    private String result;

    public Result (Calculate calc) {
        switch (calc.getOperation()) {
            case 1:
                this.result = String.valueOf(Double.valueOf(calc.getOldNumber()) + Double.valueOf(calc.getNewNumber()));
                break;
            case 3:
                this.result = Double.valueOf(calc.getNewNumber()) == 0
                        ? "Деление на ноль - бесконечность" :
                        String.valueOf(Double.valueOf(calc.getOldNumber()) / Double.valueOf(calc.getNewNumber()));
                break;
            case 2:
                this.result = String.valueOf(Double.valueOf(calc.getOldNumber())*Double.valueOf(calc.getNewNumber()));
                break;
            case 4:
                this.result = String.valueOf(Double.valueOf(calc.getOldNumber())-Double.valueOf(calc.getNewNumber()));
                break;
        }
    }

    public String getResult() {
        return result;
    }
}
