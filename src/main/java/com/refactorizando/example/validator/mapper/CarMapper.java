package com.refactorizando.example.validator.mapper;

import com.refactorizando.example.validator.dto.CarDTO;
import com.refactorizando.example.validator.entity.CarEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMapper {

  CarEntity toEntity(CarDTO dto);

  CarDTO toDto(CarEntity entity);
}
