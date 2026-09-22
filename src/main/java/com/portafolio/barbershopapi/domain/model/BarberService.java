package com.portafolio.barbershopapi.domain.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BarberService {

    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer durationMinutes;

}
