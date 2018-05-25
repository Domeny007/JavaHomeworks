package ru.kpfu.itis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.repository.SessionHistory;
import ru.kpfu.itis.model.Calculator;
import ru.kpfu.itis.model.Operation;
import ru.kpfu.itis.repository.CalculatorRepository;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Autowired
    CalculatorRepository repository;

    @Autowired
    SessionHistory history;

    @Override
    public void addDigit(Double digit) {
        repository.addDigit(digit);
    }

    @Override
    public void addMathAction(String oper) {
        repository.addMathAction(oper);
    }

    @Override
    public Double getDigit() {
        return repository.getDigit();
    }

    @Override
    public String getMathAction() {
        return repository.getMathAction();
    }

    @Override
    public Calculator calculate(Double digit, String operation) {
        Calculator calc = new Calculator();
        Double a = getDigit();
        Double b = digit;
        double result = 0;
        try {
            result = Operation.calc(getMathAction(), a, b);
        } catch (ArithmeticException ae) {
            ae.printStackTrace();
        }
        calc.setDigit(String.valueOf(result));
        addDigit(result);
        history.addResult(result);
        if (operation.equals("=")) {
            addDigit(null);
            return calc;
        }
        calc.setOperation(operation);
        addMathAction(operation);

        return calc;
    }

    @Override
    public Double getResult() {
        return history.getResult();
    }
}
