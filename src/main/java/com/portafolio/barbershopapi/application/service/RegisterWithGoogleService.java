package com.portafolio.barbershopapi.application.service;

import com.portafolio.barbershopapi.domain.model.User;
import com.portafolio.barbershopapi.domain.port.in.RegisterWithGoogleUseCase;
import com.portafolio.barbershopapi.domain.port.out.UserRepository;

import java.util.Optional;

public class RegisterWithGoogleService implements RegisterWithGoogleUseCase {

    private final UserRepository userRepository;

    public RegisterWithGoogleService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User execute(String googleId, String name, String lastName, String email) {
        Optional<User> existingUser = userRepository.findByEmail(email);

        if (existingUser.isPresent()){
            return existingUser.get();
        }

        User newUser = User.builder()
                .firstName(name)
                .lastName(lastName)
                .email(email)
                .googleId(googleId)
                .build();

        return userRepository.save(newUser);

    }
}
