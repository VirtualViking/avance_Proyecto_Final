package com.example.velocerentalsspring.domain.dtos.vehicle;

public record UpdateVehicleDTO(
        Long id,
        String brand,
        String urlImage,
        String model,
        Double rentalPrice
) {
}
