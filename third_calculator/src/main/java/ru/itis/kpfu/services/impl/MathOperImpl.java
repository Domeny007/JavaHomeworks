package ru.itis.kpfu.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.kpfu.models.MathOper;
import ru.itis.kpfu.models.User;
import ru.itis.kpfu.repository.MathOperRepository;
import ru.itis.kpfu.services.MathOperService;
import ru.itis.kpfu.components.MathComponent;

import java.util.List;

@Service
public class MathOperImpl implements MathOperService {

    @Autowired
    private MathComponent math;

    @Autowired
    private MathOperRepository mathOperRepository;

    @Override
    public void saveNewOper(User owner, MathOper operation) {

        operation.setOwner(owner);
        math.proceedMath(operation);
        mathOperRepository.save(operation);
    }

    @Override
    public List<Double> getSessionHistory() {
        return math.getHistory();
    }
}
