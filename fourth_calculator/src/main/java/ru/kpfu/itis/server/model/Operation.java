package ru.kpfu.itis.server.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "operations")
public class Operation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Double digit;

    private Character mathAction;

    public Operation(){}

    public Operation(Double digit, Character mathAction) {
        this.digit = digit;
        this.mathAction = mathAction;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getDigit() {
        return digit;
    }

    public void setDigit(Double digit) {
        this.digit = digit;
    }

    public Character getMathAction() {
        return mathAction;
    }

    public void setMathAction(Character mathAction) {
        this.mathAction = mathAction;
    }
}
