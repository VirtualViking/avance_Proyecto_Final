package com.example.velocerentalsspring.domain.dtos.user;

public record CreateUserDTO(
    String firstName,
    String lastName,
    String email,
    String password
) {
}
