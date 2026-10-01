package com.portafolio.barbershopapi.infraestructure.adapters.in.web;

import com.portafolio.barbershopapi.application.dto.AuthResponse;
import com.portafolio.barbershopapi.application.dto.LoginRequest;
import com.portafolio.barbershopapi.domain.model.User;
import com.portafolio.barbershopapi.domain.port.in.AuthenticateUserUseCase;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthenticateUserUseCase authenticateUserUseCase;

    public AuthController(AuthenticateUserUseCase authenticateUserUseCase) {
        this.authenticateUserUseCase = authenticateUserUseCase;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request){
        User user = authenticateUserUseCase.execute(request.email(), request.password());

        return ResponseEntity.ok(new AuthResponse("token-jwt-de-prueba"));
    }


}
