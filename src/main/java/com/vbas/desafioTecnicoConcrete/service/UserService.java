package com.vbas.desafioTecnicoConcrete.service;

import com.vbas.desafioTecnicoConcrete.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User getUserById(Long userId);

    User getUserByUsername(String username);

}
