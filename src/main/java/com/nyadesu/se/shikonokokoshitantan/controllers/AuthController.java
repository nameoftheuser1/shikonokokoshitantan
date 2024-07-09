package com.nyadesu.se.shikonokokoshitantan.controllers;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nyadesu.se.shikonokokoshitantan.DTO.RegistrationRequest;
import com.nyadesu.se.shikonokokoshitantan.Repository.RoleRepository;
import com.nyadesu.se.shikonokokoshitantan.Repository.UserAuthRepository;
import com.nyadesu.se.shikonokokoshitantan.model.Role;
import com.nyadesu.se.shikonokokoshitantan.model.UserAuth;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    
    @Autowired
    UserAuthRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegistrationRequest registrationRequest){

        if(userRepository.existsByUsername(registrationRequest.getUsername())){
            return new ResponseEntity<>("Username is already take!", HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(registrationRequest.getEmail())){
            return new ResponseEntity<>("An account is already registered in this email", HttpStatus.BAD_REQUEST);
        }

        UserAuth user = new UserAuth(
            registrationRequest.getUsername(),
            registrationRequest.getEmail(),
            passwordEncoder.encode(registrationRequest.getPassword())
        );

        Role role = roleRepository.findByName("ROLE_ADMIN").get();
        user.setRoles(Collections.singleton(role));

        userRepository.save(user);

        return new ResponseEntity<>("User registered successfully", HttpStatus.OK); 
        
    }
    @PostMapping("/register/user")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationRequest registrationRequest){

        if(userRepository.existsByUsername(registrationRequest.getUsername())){
            return new ResponseEntity<>("Username is already take!", HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(registrationRequest.getEmail())){
            return new ResponseEntity<>("An account is already registered in this email", HttpStatus.BAD_REQUEST);
        }

        UserAuth user = new UserAuth(
            registrationRequest.getUsername(),
            registrationRequest.getEmail(),
            passwordEncoder.encode(registrationRequest.getPassword())
        );

        Role role = roleRepository.findByName("ROLE_USER").get();
        user.setRoles(Collections.singleton(role));

        userRepository.save(user);

        return new ResponseEntity<>("User registered successfully", HttpStatus.OK); 
        
    }
}
