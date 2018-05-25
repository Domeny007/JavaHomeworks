package ru.kpfu.itis.util;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.kpfu.itis.model.Calculator;
import ru.kpfu.itis.service.CalculatorService;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorFormValidator implements Validator {

    static Pattern p = Pattern.compile("^[0-9]*[.,][0-9]+$");
    String error = "error";

    @Override
    public boolean supports(Class<?> aClass) {
        return Calculator.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Calculator calc = (Calculator) o;
        if (calc.getDigit() == null) {
            String incorrectError = "Введены некорректные данные";
            errors.rejectValue(error, "", incorrectError);
        }
        try {
            Double digit = Double.valueOf(calc.getDigit());
        } catch (NumberFormatException e) {
            String incorrectInputError = "Можно вводить только цифры";
            errors.rejectValue(error, "", incorrectInputError);
        }
    }

    public void validateByZero(CalculatorService service, Calculator calc, Errors errors) {
        try {
            Double digit = Double.valueOf(calc.getDigit());
            if (digit == 0 &&
                    Objects.equals(service.getMathAction(), "/")) {
                service.addDigit(null);
                String divZero = "Деление не ноль, бесконечность";
                errors.rejectValue(error, "", divZero);
            }
        } catch (NumberFormatException e) {
            validate(calc, errors);
        }
    }
}
