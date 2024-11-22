package ru.javamentor.crudapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.javamentor.crudapplication.dao.UserDao;
import ru.javamentor.crudapplication.model.User;
import ru.javamentor.crudapplication.service.UserService;


import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @PostMapping
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User saved successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/list")
    @ResponseBody
    public List<User> listUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        User user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        user.setName(updatedUser.getName());
        userService.updateUser(user);
        return ResponseEntity.ok(user);
    }
}
