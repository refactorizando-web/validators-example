package com.refactorizando.example.validator;

import com.refactorizando.example.validator.dto.CarDTO;
import com.refactorizando.example.validator.mapper.CarMapper;
import com.refactorizando.example.validator.repository.CarRepository;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/cars")
@RestController
public class CarController {

  private final CarRepository carRepository;

  private final CarMapper carMapper;

  @PostMapping
  public ResponseEntity<CarDTO> saveCar(@Valid @RequestBody CarDTO carDTO) {

    var car = carMapper.toDto(
        carRepository.save(carMapper.toEntity(carDTO)));

    return ResponseEntity.ok(car);

  }
}
