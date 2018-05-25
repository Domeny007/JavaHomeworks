package ru.itis.kpfu.forms;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.ScriptAssert;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@ScriptAssert(lang = "javascript", script = "_this.repassword.equals(_this.password)", message = "Пароли должны совпадать")
@Data
public class UserRegistrationForm {

    @NotEmpty(message="Введите пароль")
    @Size(min=6, max=24, message="Минимальная длина пароля: 6, максимальная: 24")
    @Pattern(regexp="^(?:\\d+\\D+|\\D+\\d+)$", message="Пароль должен содержать символы и числа")
    private String password;

    private String repassword;

    @NotEmpty(message="Введите email")
    @Email(message="Проверьте корректность введённого email")
    private String email;
}
