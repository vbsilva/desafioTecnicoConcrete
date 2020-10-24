package com.vbas.desafioTecnicoConcrete.repository;

import com.vbas.desafioTecnicoConcrete.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<User, Long> {

}
