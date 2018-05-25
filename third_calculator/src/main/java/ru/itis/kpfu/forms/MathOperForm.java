package ru.itis.kpfu.forms;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

@Data
public class MathOperForm {

    @NotEmpty(message="Пожалуйста, введите число!")
    @Pattern(regexp="^\\d+$", message="Проверьте ввод, число не распознано")
    private String number;

    @NotEmpty(message="Вы должны выбрать функцию!")
    private String function;
}
