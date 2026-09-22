package com.portafolio.barbershopapi.domain.port.out;

import com.portafolio.barbershopapi.domain.model.BarberService;

import java.util.List;
import java.util.Optional;

public interface BarberServiceRepository {

    List<BarberService> findAll();

    BarberService save(BarberService service);

    Optional<BarberService> findById(Integer id);

    boolean deleteById(Integer id);
}