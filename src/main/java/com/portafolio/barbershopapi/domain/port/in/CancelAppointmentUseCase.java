package com.portafolio.barbershopapi.domain.port.in;

import com.portafolio.barbershopapi.domain.model.Appointment;

public interface CancelAppointmentUseCase {

    boolean execute(Integer appointmentId);
}
