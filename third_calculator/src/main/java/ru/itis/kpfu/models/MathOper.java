package ru.itis.kpfu.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@SequenceGenerator(name = "math_gen", sequenceName = "math_seq", allocationSize = 1)
@Table(name = "math")
@Data
public class MathOper {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "math_gen")
    private long id;

    @NotNull(message="Не введено число")
    private String number;

    @NotNull(message="Не выбрана функция")
    private String function;

    @ManyToOne
    @NotNull(message="Не определен пользователь")
    @JoinColumn
    private User owner;

    @Override
    public String toString() {
        return "(" + number + ", " + function + ")";
    }
}
