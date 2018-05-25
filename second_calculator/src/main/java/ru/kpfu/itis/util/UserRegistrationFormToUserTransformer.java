package ru.kpfu.itis.util;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.kpfu.itis.form.UserRegistrationForm;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.model.enums.UserRole;

public class UserRegistrationFormToUserTransformer {

    static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static User transform(UserRegistrationForm form) {
        if (form == null) {
            return null;
        }
        User owner = new User();
        owner.setUsername(form.getUsername());
        owner.setRole(UserRole.ROLE_USER);
        owner.setEmail(form.getEmail());
        owner.setPassword(encoder.encode(form.getPassword()));
        return owner;
    }
}
