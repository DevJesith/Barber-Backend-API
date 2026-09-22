package com.portafolio.barbershopapi.domain.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private Integer id;
    private String firstName;
    private String lastName;
    private Role role;
    private String email;
    private String password;
    private LocalDateTime createdAt;
}
