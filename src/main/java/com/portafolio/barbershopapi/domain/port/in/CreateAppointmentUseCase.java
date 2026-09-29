package com.portafolio.barbershopapi.domain.port.in;

import com.portafolio.barbershopapi.domain.model.Appointment;

import java.time.LocalDateTime;

public interface CreateAppointmentUseCase {

    Appointment execute(
            Integer clientId,
            Integer barberId,
            Integer serviceId,
            LocalDateTime appointmentDateTime
    );

}
