package com.portafolio.barbershopapi.domain.port.in;

import com.portafolio.barbershopapi.domain.model.Appointment;
import com.portafolio.barbershopapi.domain.model.User;

import java.time.LocalDate;
import java.util.List;

public interface GetBarberScheduleUseCase {

    List<Appointment> execute(
            Integer barberId,
            LocalDate date
    );
}
