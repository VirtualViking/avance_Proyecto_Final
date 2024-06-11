package com.example.velocerentalsspring.infrastructure.adapters.repositories;

import com.example.velocerentalsspring.domain.models.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {
}
