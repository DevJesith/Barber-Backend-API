package com.portafolio.barbershopapi.domain.port.in;

import com.portafolio.barbershopapi.domain.model.User;

public interface AuthenticateUserUseCase {

    User execute(
            String email,
            String password
    );

}
