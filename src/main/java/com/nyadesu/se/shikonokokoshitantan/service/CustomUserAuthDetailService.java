package com.nyadesu.se.shikonokokoshitantan.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nyadesu.se.shikonokokoshitantan.Repository.UserAuthRepository;
import com.nyadesu.se.shikonokokoshitantan.model.UserAuth;

@Service
public class CustomUserAuthDetailService implements UserDetailsService {

    private UserAuthRepository repo;

    public CustomUserAuthDetailService(UserAuthRepository repo) {
        this.repo = repo;
    }

    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException{
        UserAuth userAuth = repo.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail).orElseThrow(
            () -> new UsernameNotFoundException("Username not found with username or email" + usernameOrEmail));

        Set<GrantedAuthority> authorities = userAuth
        .getRoles()
        .stream()
        .map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(
            userAuth.getEmail(),
            userAuth.getPassword(),
            authorities
        );
        

    }
}
