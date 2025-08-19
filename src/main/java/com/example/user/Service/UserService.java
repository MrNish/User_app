package com.example.user.Service;

import com.example.user.Dto.UserDto;
import com.example.user.Entity.User;
import com.example.user.Repository.UserRepo;
import com.example.user.exceptions.UserNotFoundException;
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
        return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found"));
    }

    public User addUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        return userRepo.save(user);
    }

    public User updateUser(UserDto userDto, int id) {
        User exisitingUser = userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User with ID: " + id + " not found"));
        exisitingUser.setEmail(userDto.getEmail());
        exisitingUser.setName(userDto.getName());
        return userRepo.save(exisitingUser);
    }

    public String deleteUser(int id) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found"));
        userRepo.deleteById(id);
        return "User Deleted Successfully";
    }
}
