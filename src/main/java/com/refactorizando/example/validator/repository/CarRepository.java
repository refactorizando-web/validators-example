package com.refactorizando.example.validator.repository;

import com.refactorizando.example.validator.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarEntity, Long> {

}
