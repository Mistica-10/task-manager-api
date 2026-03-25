package com.example.taskapi.controller;
import com.example.taskapi.dto.ApiResponse;
import com.example.taskapi.model.User;
import com.example.taskapi.service.UserService;
import com.example.taskapi.repository.UserRepository;
import com.example.taskapi.util.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserRepository userRepository;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    public AuthController(UserService userService,
                          UserRepository userRepository,
                          PasswordEncoder passwordEncoder,
                          JwtUtil jwtUtil){
        this.userService=userService;
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
        this.jwtUtil=jwtUtil;
    }
    //register
    @PostMapping("/register")
    public ApiResponse<String> register(@RequestBody User user){
        userService.register(user);
        return new ApiResponse<>("success","User Registered Successfully",null);
    }
    //login
    @PostMapping("/login")
    public ApiResponse<String> login(@RequestBody User user){
        User existingUser=userRepository.findByUsername(user.getUsername()).orElse(null);
        if(existingUser == null){
            return new ApiResponse<>("error","User not found",null);
        }
        if(passwordEncoder.matches(user.getPassword(),existingUser.getPassword())){
            //Generate JWT with role
            String token=jwtUtil.generateToken(existingUser.getUsername(),existingUser.getRole().name());
            return new ApiResponse<>("success","Login successful",token);
        }
        return new ApiResponse<>("error","Invalid password",null);
    }
}
