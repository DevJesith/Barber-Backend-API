package com.portafolio.barbershopapi.domain.port.in;

import com.portafolio.barbershopapi.domain.model.BarberService;

import java.util.List;

public interface GetBarberServicesUseCase {

    List<BarberService> execute();
}
