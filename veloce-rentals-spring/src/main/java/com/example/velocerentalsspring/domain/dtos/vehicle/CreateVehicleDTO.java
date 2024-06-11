package com.example.velocerentalsspring.domain.dtos.vehicle;

import com.example.velocerentalsspring.domain.enums.Type;

public record CreateVehicleDTO(
        String brand,
        String urlImage,
        String model,
        Type type,
        Double rentalPrice
) {
}
