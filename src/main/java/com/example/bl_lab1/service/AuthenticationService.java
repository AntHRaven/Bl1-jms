package com.example.bl_lab1.service;

import com.example.bl_lab1.config.CustomUserDetails;
import java.util.ArrayList;
import java.util.List;

import com.example.bl_lab1.model.User;
import lombok.SneakyThrows;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService
      implements UserDetailsService {

    private final UserDAO userDAO;

    public AuthenticationService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @SneakyThrows
    @Override
    public CustomUserDetails loadUserByUsername(String username) {
        User user = userDAO.getUser(username);

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        return new CustomUserDetails(user.getId(), username, user.getPassword(), authorities);
    }
}
