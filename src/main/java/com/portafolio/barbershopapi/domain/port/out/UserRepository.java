package com.portafolio.barbershopapi.domain.port.out;

import com.portafolio.barbershopapi.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    List<User> findAll();

    User save(User user);

    Optional<User> findByEmail(String email);

    Optional<User> findById(Integer id);

    boolean deleteById(Integer id);
}