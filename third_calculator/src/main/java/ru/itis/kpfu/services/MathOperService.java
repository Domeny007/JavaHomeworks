package ru.itis.kpfu.services;

import ru.itis.kpfu.models.MathOper;
import ru.itis.kpfu.models.User;

import java.util.List;

public interface MathOperService {
    void saveNewOper(User owner, MathOper operation);
    List<Double> getSessionHistory();
}
