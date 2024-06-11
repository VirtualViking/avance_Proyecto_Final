package com.example.velocerentalsspring.application.services.imp;

import com.example.velocerentalsspring.application.mappers.UserMapper;
import com.example.velocerentalsspring.application.services.UserService;
import com.example.velocerentalsspring.domain.dtos.user.CreateUserDTO;
import com.example.velocerentalsspring.domain.dtos.user.UpdateUserDTO;
import com.example.velocerentalsspring.domain.dtos.user.UserOutDTO;
import com.example.velocerentalsspring.domain.models.User;
import com.example.velocerentalsspring.infrastructure.adapters.repositories.UserRepository;
import com.example.velocerentalsspring.infrastructure.exceptions.UserException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {
  private UserRepository repository;
  private UserMapper mapper;
  @Override
  public UserOutDTO save(CreateUserDTO user) {
    User userSaved = repository.save(mapper.toEntity(user));
    return mapper.toDTO(userSaved);
  }

  @Override
  public List<UserOutDTO> getAll() {
    return mapper.toDTO(
            repository.findAll() // --> List<User>
    );
  }

  @Override
  public Optional<UserOutDTO> getById(Long id) {
    return repository
            .findById(id)
            .map(mapper::toDTO);
  }

  @Override
  public Optional<UserOutDTO> update(UpdateUserDTO user) {
    Optional<User> userOptional = repository.findById(user.id());
    if (userOptional.isEmpty()) {
      return Optional.empty();
    }
    User userToUpdate = userOptional.get();

    if(user.firstName() != null) {
      userToUpdate.setFirstName(user.firstName());
    }

    if(user.lastName() != null) {
      userToUpdate.setLastName(user.lastName());
    }

    if(user.password() != null) {
      userToUpdate.setPassword(user.password());
    }

    User userUpdated = repository.save(userToUpdate);

    return Optional.of(
            mapper.toDTO(userUpdated)
    );
  }

  @Override
  public void deleteById(Long id) {
    Optional<User> userOptional = repository.findById(id);
    if (userOptional.isEmpty()) {
      throw new UserException(HttpStatus.NOT_FOUND,"The user with id " + id + " was not found.");
    }
    repository.deleteById(id);
  }
}
