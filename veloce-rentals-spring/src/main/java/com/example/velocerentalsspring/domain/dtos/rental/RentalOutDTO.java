package com.example.velocerentalsspring.domain.dtos.rental;

import com.example.velocerentalsspring.domain.dtos.user.UserOutDTO;
import com.example.velocerentalsspring.domain.dtos.vehicle.VehicleOutDTO;
import java.time.LocalDateTime;

public record RentalOutDTO(
        Long id,
        UserOutDTO user,
        VehicleOutDTO vehicle,
        LocalDateTime startDate,
        LocalDateTime endDate
) {
}
