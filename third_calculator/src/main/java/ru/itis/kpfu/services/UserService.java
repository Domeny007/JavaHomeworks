package ru.itis.kpfu.services;

import ru.itis.kpfu.forms.UserRegistrationForm;
import ru.itis.kpfu.models.User;

public interface UserService {
    void saveNewUser(UserRegistrationForm form);
    User getUserWithEmail(String email);
}
