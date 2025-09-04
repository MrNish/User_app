package com.example.user.Service;

import com.example.user.Dto.UserDto;
import com.example.user.Entity.User;
import com.example.user.Repository.UserRepo;
import com.example.user.exceptions.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public UserDto mapToDto(User user) {
        return new UserDto(user.getId(), user.getName(), user.getEmail());
    }

    public User mapToEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        return user;
    }

    public List<UserDto> getAllUser() {
        List<User> users =  userRepo.findAll();
        return users.stream()
                .map(user -> new UserDto(user.getId(), user.getName(), user.getEmail()))
                .collect(Collectors.toList());
    }

    public UserDto getUser(int id) {
        User user =  userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found"));
        return mapToDto(user);
    }

    public UserDto addUser(UserDto userDto) {
        User user = mapToEntity(userDto);
        return mapToDto(userRepo.save(user));
    }

    public UserDto updateUser(UserDto userDto, int id) {
        User exisitingUser = userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User with ID: " + id + " not found"));
        exisitingUser.setEmail(userDto.getEmail());
        exisitingUser.setName(userDto.getName());
        return mapToDto(userRepo.save(exisitingUser));
    }

    public String deleteUser(int id) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found"));
        userRepo.deleteById(id);
        return "User Deleted Successfully";
    }
}
