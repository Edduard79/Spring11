package com.example.Ex11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("")
    public User createUser(@RequestBody User user) {
        return userRepo.save(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable String id) {
        return userRepo.findById(id);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable String id, @RequestBody User user) {
        User currentUser = userRepo.findById(id).orElseThrow();
        currentUser.setName(user.getName());
        currentUser.setSurname(user.getSurname());
        userRepo.save(currentUser);
    }

    @DeleteMapping
    public void deleteUser() {
        userRepo.deleteAll();
    }


}
