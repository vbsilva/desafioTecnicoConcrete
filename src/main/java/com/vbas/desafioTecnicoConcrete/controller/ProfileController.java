package com.vbas.desafioTecnicoConcrete.controller;

import com.vbas.desafioTecnicoConcrete.model.User;
import com.vbas.desafioTecnicoConcrete.model.UserDTO;
import com.vbas.desafioTecnicoConcrete.service.UserService;
import com.vbas.desafioTecnicoConcrete.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfileController {

    @Autowired
    UserService userService;

    @Autowired
    JwtUtil jwtUtil;

    @GetMapping("/profile")
    @ResponseBody
    public ResponseEntity userProfile(@RequestHeader(name = "Authorization") String token) {
        String username = jwtUtil.extractUsername(token.substring(7));
        User userdb = userService.getUserByEmail(username);
        UserDTO userDTO = new UserDTO(userdb);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(userDTO);
    }


}
