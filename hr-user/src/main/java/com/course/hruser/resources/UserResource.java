package com.course.hruser.resources;

import com.course.hruser.entities.User;
import com.course.hruser.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User user = service.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email){
        User user = service.findByEmail(email);
        return ResponseEntity.ok().body(user);
    }
}
