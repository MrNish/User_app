package com.example.user.Controller;

import com.example.user.Entity.User;
import com.example.user.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUser() {
        List<User> users = userService.getAllUser();
        return users;
    }

    @GetMapping("/getUser")
    public User getUser(@RequestParam int id) {
        return userService.getUser(id);
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody User user) {
        userService.addUser(user);
        return "UserAdded";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "UserDeleted";
    }
}
