package com.vbas.desafioTecnicoConcrete.service;

import com.vbas.desafioTecnicoConcrete.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.vbas.desafioTecnicoConcrete.model.User userDb = userService.getUserByEmail(username);
        if (userDb != null && userDb.getEmail() != null && userDb.getPassword() != null) {
            return new User(userDb.getEmail(), userDb.getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("Username not found");
        }

    }
}
