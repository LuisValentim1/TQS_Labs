package com.example.CarInfoSys.Services;

import org.springframework.stereotype.Service;
import com.example.CarInfoSys.Entities.Car;
import com.example.CarInfoSys.Repository.CarRepository;

@Service
public class CarService {


    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }



    public Car getCarDetails(String key) {
        return  carRepository.findByName( key);
    }
}
