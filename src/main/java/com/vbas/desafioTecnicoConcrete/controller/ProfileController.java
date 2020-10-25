package com.vbas.desafioTecnicoConcrete.controller;

import com.vbas.desafioTecnicoConcrete.model.User;
import com.vbas.desafioTecnicoConcrete.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfileController {

    @Autowired
    UserService userService;

    @GetMapping("/profile")
    @ResponseBody
    public ResponseEntity userProfile(@RequestBody String username) {
        System.out.println("usernameeeee " + username);
        User userdb = userService.getUserByEmail(username);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(userdb);
    }

    @GetMapping("/proffile")
    public String user() {
        return "sdfgsdfg";
    }
}
