package com.course.hruser.services;

import com.course.hruser.entities.User;
import com.course.hruser.repositories.UserRepository;
import com.course.hruser.services.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository repository;

    public User findById(Long id){
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User findByEmail(String email){
        User user = repository.findByEmail(email);
        if (user == null) {
            logger.error("Email not found: " + email);
            throw new IllegalArgumentException("Email not found");
        }
        logger.info("Email found: " + email);
        return user;
    }
}
