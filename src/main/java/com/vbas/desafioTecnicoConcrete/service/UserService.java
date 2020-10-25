package com.vbas.desafioTecnicoConcrete.service;

import com.vbas.desafioTecnicoConcrete.model.User;

import java.util.List;

public interface UserService {

    User createUpdateUser(User user);

    User getUserByEmail(String email);

}
