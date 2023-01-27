package com.quesito.rest;


import com.quesito.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class UserController {


    private final KafkaTemplate<String, User> kafkaTemplate;

    @PostMapping
    public  void createUser(@RequestBody User user){
        kafkaTemplate.send("customers",user);
    }



}
