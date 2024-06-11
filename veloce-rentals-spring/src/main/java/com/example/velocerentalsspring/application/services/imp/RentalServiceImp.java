package com.example.velocerentalsspring.application.services.imp;

import com.example.velocerentalsspring.application.mappers.UserMapper;
import com.example.velocerentalsspring.application.mappers.VehicleMapper;
import com.example.velocerentalsspring.application.services.RentalService;
import com.example.velocerentalsspring.application.services.UserService;
import com.example.velocerentalsspring.application.services.VehicleService;
import com.example.velocerentalsspring.domain.dtos.rental.CreateRentalDTO;
import com.example.velocerentalsspring.domain.dtos.rental.RentalOutDTO;
import com.example.velocerentalsspring.domain.dtos.user.UserOutDTO;
import com.example.velocerentalsspring.domain.dtos.vehicle.VehicleOutDTO;
import com.example.velocerentalsspring.domain.models.Rental;
import com.example.velocerentalsspring.infrastructure.adapters.repositories.RentalRepository;
import com.example.velocerentalsspring.infrastructure.exceptions.UserException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RentalServiceImp implements RentalService {
  private final RentalRepository rentalRepository;
  private final UserService userService;
  private final UserMapper userMapper;
  private final VehicleService vehicleService;
  private final VehicleMapper vehicleMapper;
  @Override
  public RentalOutDTO createRental(CreateRentalDTO createRentalDTO) {
    UserOutDTO user = userService.getById(createRentalDTO.userId())
            .orElseThrow(() -> new UserException(HttpStatus.NOT_FOUND, "User not found"));

    VehicleOutDTO vehicle = vehicleService.getById(createRentalDTO.vehicleId())
            .orElseThrow(() -> new UserException(HttpStatus.NOT_FOUND, "Vehicle not found"));

    Double totalPrice = calculateRentalPrice(vehicle, createRentalDTO.startDate(), createRentalDTO.endDate());

    Rental rental = Rental.builder()
            .vehicle(vehicleMapper.toEntity(vehicle))
            .user(userMapper.toEntity(user))
            .startDate(createRentalDTO.startDate())
            .endDate(createRentalDTO.endDate())
            .totalPrice(totalPrice)
            .build();


    return null;
  }


  private Double calculateRentalPrice(VehicleOutDTO vehicle, LocalDateTime startDate, LocalDateTime endDate) {
    Integer days = endDate.getDayOfYear() - startDate.getDayOfYear();
    return vehicle.rentalPrice() * days;
  }
}
