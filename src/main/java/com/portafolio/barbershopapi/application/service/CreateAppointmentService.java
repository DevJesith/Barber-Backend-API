package com.portafolio.barbershopapi.application.service;

import com.portafolio.barbershopapi.domain.model.Appointment;
import com.portafolio.barbershopapi.domain.model.AppointmentStatus;
import com.portafolio.barbershopapi.domain.model.BarberService;
import com.portafolio.barbershopapi.domain.model.User;
import com.portafolio.barbershopapi.domain.port.in.CreateAppointmentUseCase;
import com.portafolio.barbershopapi.domain.port.out.AppointmentRepository;
import com.portafolio.barbershopapi.domain.port.out.BarberServiceRepository;
import com.portafolio.barbershopapi.domain.port.out.UserRepository;

import java.time.LocalDateTime;

public class CreateAppointmentService implements CreateAppointmentUseCase {

    private final UserRepository userRepository;
    private final BarberServiceRepository barberServiceRepository;
    private final AppointmentRepository appointmentRepository;

    public CreateAppointmentService(UserRepository userRepository, BarberServiceRepository barberServiceRepository, AppointmentRepository appointmentRepository) {
        this.userRepository = userRepository;
        this.barberServiceRepository = barberServiceRepository;
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment execute(Integer clientId, Integer barberId, Integer serviceId, LocalDateTime appointmentDateTime) {

        // 1. Buscar y validar al cliente
        User client = userRepository.findById(clientId).orElseThrow(() -> new IllegalArgumentException("Client not found with ID: " + clientId));

//        2. Buscar y validar al barbero
        User barber = userRepository.findById(barberId).orElseThrow(() -> new IllegalArgumentException("Barber not found with ID: " + barberId));

//        3. Buscar y validar el servicio
        BarberService service = barberServiceRepository.findById(serviceId).orElseThrow(() -> new IllegalArgumentException("Service not found with ID: " + serviceId));


//        4. Instanciar el objeto de dominio con sus datos iniciales
        Appointment newAppointment = Appointment.builder()
                .client(client)
                .barber(barber)
                .service(service)
                .price(service.getPrice())
                .appointmentDateTime(appointmentDateTime)
                .status(AppointmentStatus.PENDING)
                .build();


        // 5. Persistir la cita a traves del puerto de salida
        return appointmentRepository.save(newAppointment);
    }
}
