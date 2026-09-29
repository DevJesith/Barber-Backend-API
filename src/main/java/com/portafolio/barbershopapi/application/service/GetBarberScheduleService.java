package com.portafolio.barbershopapi.application.service;

import com.portafolio.barbershopapi.domain.model.Appointment;
import com.portafolio.barbershopapi.domain.port.in.GetBarberScheduleUseCase;
import com.portafolio.barbershopapi.domain.port.out.AppointmentRepository;

import java.time.LocalDate;
import java.util.List;

public class GetBarberScheduleService implements GetBarberScheduleUseCase {

    private final AppointmentRepository appointmentRepository;

    public GetBarberScheduleService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<Appointment> execute(Integer barberId, LocalDate date) {

        return appointmentRepository.findByBarberIdAndAppointmentDate(barberId, date);

    }
}
