package com.example.CarInfoSys.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.CarInfoSys.Entities.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Car findByName(String name);

}
