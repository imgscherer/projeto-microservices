package com.course.hruser.services;

import com.course.hruser.entities.User;
import com.course.hruser.repositories.UserRepository;
import com.course.hruser.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User findById(Long id){
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User findByEmail(String email){
        User user = repository.findByEmail(email);
        return user;
    }
}
