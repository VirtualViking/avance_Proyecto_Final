package com.example.velocerentalsspring.application.services;

import com.example.velocerentalsspring.domain.dtos.rental.CreateRentalDTO;
import com.example.velocerentalsspring.domain.dtos.rental.RentalOutDTO;

public interface RentalService {

  RentalOutDTO createRental(CreateRentalDTO createRentalDTO);

}
