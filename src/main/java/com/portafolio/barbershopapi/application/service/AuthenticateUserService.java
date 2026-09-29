package com.portafolio.barbershopapi.application.service;

import com.portafolio.barbershopapi.domain.model.User;
import com.portafolio.barbershopapi.domain.port.in.AuthenticateUserUseCase;
import com.portafolio.barbershopapi.domain.port.out.UserRepository;

public class AuthenticateUserService implements AuthenticateUserUseCase {

     private final UserRepository userRepository;

    public AuthenticateUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User execute(String email, String password) {
        User usuario = userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("Invalid credential"));

        if (!usuario.getPassword().equals(password)){
            throw new IllegalArgumentException("Incorrect Password");
        }

        return usuario;
    }
}
