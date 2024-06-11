package com.example.velocerentalsspring.domain.dtos.rental;

import java.time.LocalDateTime;

public record CreateRentalDTO(
        Long userId,
        Long vehicleId,
        LocalDateTime startDate,
        LocalDateTime endDate
) {
}
