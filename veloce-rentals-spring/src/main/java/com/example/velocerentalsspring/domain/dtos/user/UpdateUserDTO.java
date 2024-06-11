package com.example.velocerentalsspring.domain.dtos.user;

public record UpdateUserDTO(
        Long id,
        String firstName,
        String lastName,
        String password
) {
}
