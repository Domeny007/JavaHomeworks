package ru.itis.kpfu.forms.map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.itis.kpfu.forms.UserRegistrationForm;
import ru.itis.kpfu.models.User;
import ru.itis.kpfu.models.enums.UserRoles;

public class UserRegistrationFormMapper {

    private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static User transform(UserRegistrationForm form) {
        User user = new User();
        user.setRole(UserRoles.ROLE_USER);
        user.setEmail(form.getEmail());
        user.setPassword(encoder.encode(form.getPassword()));
        return user;
    }
}
