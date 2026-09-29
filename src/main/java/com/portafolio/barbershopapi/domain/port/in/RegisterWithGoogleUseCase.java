package com.portafolio.barbershopapi.domain.port.in;

import com.portafolio.barbershopapi.domain.model.User;

import java.math.BigInteger;

public interface RegisterWithGoogleUseCase {

    User execute(
            String googleId,
            String name,
            String lastName,
            String email
    );
}
