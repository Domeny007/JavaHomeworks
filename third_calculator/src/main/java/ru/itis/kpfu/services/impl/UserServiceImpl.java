package ru.itis.kpfu.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.kpfu.forms.UserRegistrationForm;
import ru.itis.kpfu.forms.map.UserRegistrationFormMapper;
import ru.itis.kpfu.models.User;
import ru.itis.kpfu.repository.UserRepository;
import ru.itis.kpfu.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;

    @Override
    public void saveNewUser(UserRegistrationForm form) {
        User user = UserRegistrationFormMapper.transform(form);
        userRepository.save(user);
    }

    @Override
    public User getUserWithEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
