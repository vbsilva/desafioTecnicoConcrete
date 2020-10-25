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
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("EMAILLLLLLLL " + username);
        com.vbas.desafioTecnicoConcrete.model.User userDb = userRepository.findByEmail(username);
        if (userDb != null && userDb.getName() != null && userDb.getPassword() != null) {
            return new User(userDb.getName(), userDb.getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("qqqqqqqqq");
        }

    }
}
