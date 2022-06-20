package com.refactorizando.example.validator.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.refactorizando.example.validator.config.LengthValidation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class CarEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @NotBlank
  private String color;

  @NotNull
  private String model;

  @NotNull
  @NotBlank(message = "plate is required")
  @Size(min = 5, max = 10)
  private String plate;

  @LengthValidation
  private String origin;
}
