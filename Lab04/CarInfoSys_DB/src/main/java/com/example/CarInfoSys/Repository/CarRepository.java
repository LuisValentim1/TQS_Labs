package com.example.CarInfoSys.Repository;

import org.springframework.data.repository.CrudRepository;
import com.example.CarInfoSys.Entities.Car;

public interface CarRepository extends CrudRepository<Car, Integer> {

    Car findByName(String name);

}