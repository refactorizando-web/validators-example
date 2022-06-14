package com.refactorizando.example.validator.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CarDTO {

  @NotNull
  @NotBlank
  private String color;

  @NotNull
  private String model;

  @NotNull
  @NotBlank(message = "plate is required")
  @Size(min = 5, max = 10)
  private String plate;
}
