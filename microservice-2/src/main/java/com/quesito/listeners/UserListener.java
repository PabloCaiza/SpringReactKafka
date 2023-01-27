package com.quesito.listeners;

import com.quesito.dto.User;
import com.quesito.entity.UserDocument;
import com.quesito.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserListener {

    private final UserRepository userRepository;
    @KafkaListener(topics = {"customers"},groupId = "foo")
    void createUserLister(User user){
        UserDocument userDocument= UserDocument.builder()
                .name(user.name())
                .age(user.age())
                .build();
        userRepository.save(userDocument);
    }
}
