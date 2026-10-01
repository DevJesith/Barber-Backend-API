package com.portafolio.barbershopapi.infraestructure.adapters.in.web;

import com.portafolio.barbershopapi.application.dto.CreateAppointmentRequest;
import com.portafolio.barbershopapi.domain.model.Appointment;
import com.portafolio.barbershopapi.domain.port.in.CreateAppointmentUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController{

    private final CreateAppointmentUseCase createAppointmentUseCase;

    public AppointmentController(CreateAppointmentUseCase createAppointmentUseCase) {
        this.createAppointmentUseCase = createAppointmentUseCase;
    }

    @PostMapping
    public ResponseEntity<Appointment> createAppointment( @Valid @RequestBody CreateAppointmentRequest request){
        Appointment appointment = createAppointmentUseCase.execute(
                request.clientId(),
                request.barberId(),
                request.serviceId(),
                request.appointmentDatetime()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(appointment);
    }
}
