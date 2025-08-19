package com.example.user.Service;

import com.example.user.Entity.User;
import com.example.user.Repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    public User getUser(int id) {
        return userRepo.findById(id).orElse(null);
    }

    public void addUser(User user) {
        userRepo.save(user);
    }

    public void deleteUser(int id) {
        if (userRepo.findById(id).isPresent()) {
            userRepo.deleteById(id);
        }

    }
}
