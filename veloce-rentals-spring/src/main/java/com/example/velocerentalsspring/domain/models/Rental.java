package com.example.velocerentalsspring.domain.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "rentals")
public class Rental {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  private User user;
  @ManyToOne
  private Vehicle vehicle;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private Double totalPrice;

}
