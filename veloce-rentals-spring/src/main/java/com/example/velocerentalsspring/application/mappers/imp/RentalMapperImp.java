package com.example.velocerentalsspring.application.mappers.imp;

import com.example.velocerentalsspring.application.mappers.RentalMapper;
import com.example.velocerentalsspring.domain.dtos.rental.CreateRentalDTO;
import com.example.velocerentalsspring.domain.dtos.rental.RentalOutDTO;
import com.example.velocerentalsspring.domain.models.Rental;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RentalMapperImp implements RentalMapper {
  @Override
  public RentalOutDTO toDTO(Rental rental) {
    return null;
  }

  @Override
  public Rental toEntity(CreateRentalDTO rental) {
    return null;
  }

  @Override
  public List<RentalOutDTO> toDTO(List<Rental> rentals) {
    return null;
  }
}
