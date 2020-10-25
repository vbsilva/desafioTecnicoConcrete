package com.vbas.desafioTecnicoConcrete.controller;

import com.vbas.desafioTecnicoConcrete.model.ErrorMessage;
import com.vbas.desafioTecnicoConcrete.model.User;
import com.vbas.desafioTecnicoConcrete.repository.UserRepository;
import com.vbas.desafioTecnicoConcrete.service.MyUserDetailService;
import com.vbas.desafioTecnicoConcrete.service.UserService;
import com.vbas.desafioTecnicoConcrete.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class RegisterController {

    @Autowired
    UserService userService;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    MyUserDetailService myUserDetails;

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity register(@RequestBody User user) {

        if (userService.getUserByEmail(user.getEmail()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(new ErrorMessage("E-mail já existente"));
        }

        final UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), new ArrayList<>());
        final String jwt = jwtUtil.generateToken(userDetails);
        user.setToken(jwt);
        User userdb = userService.createUpdateUser(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(userdb);
    }
}
