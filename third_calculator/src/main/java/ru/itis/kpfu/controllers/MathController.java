package ru.itis.kpfu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.itis.kpfu.exceptions.UserNotFoundException;
import ru.itis.kpfu.forms.MathOperForm;
import ru.itis.kpfu.forms.map.MathOperFormMapper;
import ru.itis.kpfu.models.MathOper;
import ru.itis.kpfu.models.User;
import ru.itis.kpfu.models.rest.HistoryDTO;
import ru.itis.kpfu.models.rest.MathOperFormAndUserDTO;
import ru.itis.kpfu.repository.UserRepository;
import ru.itis.kpfu.services.MathOperService;

import javax.validation.Valid;

@Controller
public class MathController {

    @Autowired
    private MathOperService math;

    @Autowired
    private UserRepository userRepository;

    @Secured("hasRole('ROLE_USER')")
    @RequestMapping(value="/init", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MathOperFormAndUserDTO> getInitialStateOfHome() {
        MathOperFormAndUserDTO mathOperFormAndUserDTO = new MathOperFormAndUserDTO();
        mathOperFormAndUserDTO.setMathOperForm(new MathOperForm());
        User user = null;
        try {
            user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (ClassCastException e) {
            throw new UserNotFoundException();
        }
        mathOperFormAndUserDTO.setUser(user);
        return new ResponseEntity<>(mathOperFormAndUserDTO, HttpStatus.OK);
    }

    @Secured("hasRole('ROLE_USER')")
    @RequestMapping(value="/calc/{id}", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HistoryDTO> calc(@PathVariable Long id,
                                           @RequestBody @Valid MathOperForm mathOperationForm) {
        User user = userRepository.findOne(id);
        if (user == null) {
            throw new UserNotFoundException();
        }
        MathOper mathOperation = MathOperFormMapper.transform(mathOperationForm);
        math.saveNewOper(user, mathOperation);
        HistoryDTO calcHistDTO = new HistoryDTO();
        calcHistDTO.setHistory(math.getSessionHistory());
        return new ResponseEntity<>(calcHistDTO, HttpStatus.OK);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public String userNotFound() {
        return "{ 'error': 'Пользователь не найден!' }";
    }

}
