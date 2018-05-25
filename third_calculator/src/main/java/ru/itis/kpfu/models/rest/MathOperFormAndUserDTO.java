package ru.itis.kpfu.models.rest;

import lombok.Data;
import ru.itis.kpfu.forms.MathOperForm;
import ru.itis.kpfu.models.User;

@Data
public class MathOperFormAndUserDTO {

    private MathOperForm mathOperForm;
    private User user;
}
