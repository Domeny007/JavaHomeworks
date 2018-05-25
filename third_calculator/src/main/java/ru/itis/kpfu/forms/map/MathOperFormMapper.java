package ru.itis.kpfu.forms.map;

import ru.itis.kpfu.forms.MathOperForm;
import ru.itis.kpfu.models.MathOper;

public class MathOperFormMapper {

    public static MathOper transform(MathOperForm form) {
        if (form == null) return null;
        MathOper op = new MathOper();
        op.setFunction(form.getFunction());
        op.setNumber(form.getNumber());
        return op;
    }
}
