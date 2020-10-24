package com.vbas.desafioTecnicoConcrete.service;

import com.vbas.desafioTecnicoConcrete.exception.ResourceNotFoundException;
import com.vbas.desafioTecnicoConcrete.model.User;
import com.vbas.desafioTecnicoConcrete.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> userDb = this.userRepository.findById(userId);

        if (userDb.isPresent()) {
            return userDb.get();
        } else {
            throw new ResourceNotFoundException("User not found");
        }
    }


}
