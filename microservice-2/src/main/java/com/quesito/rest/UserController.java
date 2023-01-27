package com.quesito.rest;


import com.quesito.dto.User;
import com.quesito.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {
    private final UserRepository userRepository;


    @GetMapping
    public List<User> getUsers(){
        return userRepository.findAll()
                .stream()
                .map(userDocument -> new User(userDocument.getName(),userDocument.getAge()))
                .collect(Collectors.toList());

    }

}
