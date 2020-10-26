package com.vbas.desafioTecnicoConcrete.repository;

import com.vbas.desafioTecnicoConcrete.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    User findByName(String username);
}
