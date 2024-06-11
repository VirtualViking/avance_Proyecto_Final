package com.example.velocerentalsspring.domain.dtos.vehicle;

import com.example.velocerentalsspring.domain.enums.Type;
import lombok.Builder;

@Builder
public record VehicleOutDTO(
        Long id,
        String brand,
        String urlImage,
        String model,
        Type type,
        Double rentalPrice
) {
}
