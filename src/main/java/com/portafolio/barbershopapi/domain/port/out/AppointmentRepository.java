package com.portafolio.barbershopapi.domain.port.out;

import com.portafolio.barbershopapi.domain.model.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentRepository {

    List<Appointment> findAll();

    List<Appointment> findByClientId(Integer clientId);

    Appointment save(Appointment appointment);

    Optional<Appointment> findById(Integer id);

    List<Appointment> findByBarberId(Integer barberId);

    boolean deleteById(Integer id);
}