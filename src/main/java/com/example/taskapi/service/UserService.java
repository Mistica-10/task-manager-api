package com.example.taskapi.service;
import com.example.taskapi.model.User;
import com.example.taskapi.model.Role;
import com.example.taskapi.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
    }
    public User register(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        //default role
        user.setRole(Role.USER);
        return userRepository.save(user);
    }
}
