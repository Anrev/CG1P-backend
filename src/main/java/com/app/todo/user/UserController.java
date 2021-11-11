package com.app.todo.user;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins={ "http://localhost:3000", "http://localhost:4200", "https://cg1p-frontend.herokuapp.com"})
@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{userId}")
    public User getUser(@PathVariable UUID userId) {
        return userService.getUser(userId);
    }

    @GetMapping("/user/business/{businessId}")
    public List<User> getUsersByBusiness(@PathVariable UUID businessId) {
        return userService.getUsersByBusiness(businessId);
    }

    @GetMapping("/user/email/{email}")
    public User getUser(@PathVariable String email) {
        return userService.getUser(email);
    }

    @PostMapping("/user")
    public User addUser(@Valid @RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping("/user")
    public User updateUser(@Valid @RequestBody User user) {
        return userService.updateUser(user);
    }
}