package ru.itis.kpfu.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Data;
import ru.itis.kpfu.models.enums.UserRoles;

@Entity
@SequenceGenerator(name = "user_gen", sequenceName = "users_seq", allocationSize = 1)
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
    private long id;

    @NotNull(message="Введите пороль")
    private String password;

    @NotNull(message="Введите e-mail")
    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private UserRoles role;

    @Override
    public String toString() {
        return this.email + " : " + super.toString();
    }
}
