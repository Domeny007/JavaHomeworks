package ru.itis.kpfu.components;

import org.springframework.stereotype.Component;
import ru.itis.kpfu.models.MathOper;

import java.util.ArrayList;
import java.util.List;

@Component
public class MathComponent {

    private List<Double> history;
    private List<MathOper> memory;

    public List<Double> getHistory() {
        return history;
    }
    public void setHistory(List<Double> history) {
        this.history = history;
    }

    public List<MathOper> getMemory() {
        return memory;
    }
    public void setMemory(List<MathOper> memory) {
        this.memory = memory;
    }



    public void proceedMath(MathOper lastOperation) {
        memory.add(lastOperation);
        System.out.print(memory);
        if (memory.size() == 2) {
            MathOper earlierOperation = memory.get(0);
            memory.remove(0);
            Double firstNumber = Double.valueOf(earlierOperation.getNumber());
            Double secondNumber = Double.valueOf(lastOperation.getNumber());
            double tempResult;
            switch (earlierOperation.getFunction().charAt(0)) {
                case '+':
                    if (lastOperation.getFunction().charAt(0) != '=') {
                        tempResult = firstNumber + secondNumber;
                    } else {
                        tempResult = secondNumber + history.get(history.size() - 1);
                        setMemory(new ArrayList<MathOper>());
                    }
                    history.add(tempResult);
                    break;
                case '-':
                    if (lastOperation.getFunction().charAt(0) != '=') {
                        tempResult = firstNumber - secondNumber;
                    } else {
                        tempResult = history.get(history.size() - 1) - secondNumber;
                        setMemory(new ArrayList<MathOper>());
                    }
                    history.add(tempResult);
                    break;
                case '*':
                    if (lastOperation.getFunction().charAt(0) != '=') {
                        tempResult = firstNumber * secondNumber;
                    } else {
                        tempResult = secondNumber * history.get(history.size() - 1);
                        setMemory(new ArrayList<MathOper>());
                    }
                    history.add(tempResult);
                    break;
                case '/':
                    if (lastOperation.getFunction().charAt(0) != '=') {
                        tempResult = firstNumber / secondNumber;
                    } else {
                        tempResult = history.get(history.size() - 1) / secondNumber;
                        setMemory(new ArrayList<MathOper>());
                    }
                    history.add(tempResult);
                    break;
                case '=':
                    break;
            }
        } else if (memory.size() == 1){
            history.add(Double.valueOf(lastOperation.getNumber()));
        }
    }
}
