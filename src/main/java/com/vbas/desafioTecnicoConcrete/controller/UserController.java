package com.vbas.desafioTecnicoConcrete.controller;

import com.vbas.desafioTecnicoConcrete.exception.ResourceNotFoundException;
import com.vbas.desafioTecnicoConcrete.model.User;
import com.vbas.desafioTecnicoConcrete.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/create")
    public String create() {
        return "ae";
    }


}
