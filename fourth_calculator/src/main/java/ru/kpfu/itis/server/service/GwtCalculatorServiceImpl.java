package ru.kpfu.itis.server.service;

import ru.kpfu.itis.client.GwtCalculatorService;
import ru.kpfu.itis.server.model.Operation;
import ru.kpfu.itis.server.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("GwtCalculator")
public class GwtCalculatorServiceImpl  implements GwtCalculatorService {

    @Autowired
    OperationRepository operationRepository;

    Double result = 0.0;

    @Override
    public void saveOperation(Operation operation) {
        operationRepository.save(operation);
    }

    @Override
    public Double compute(Double a, Character mathAction) {

        switch (mathAction) {
            case '+':
                result = result + a;
                break;
            case '-':
                result = result - a;
                break;
            case '*':
                result = result * a;
                break;
            case '/':
                result = result / a;
                break;
            default:
                result = 0.0;
                break;
        }
        return result;
    }

    @Override
    public Double setResult(Double a, Character mathAction){
        result = a;
        return result;
    }
}