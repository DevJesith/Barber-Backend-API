package com.portafolio.barbershopapi.domain.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Appointment {

    private Integer id;
    private LocalDateTime appointmentDateTime;
    private BarberService service;
    private User barber;
    private User client;
    private AppointmentStatus status;
}
