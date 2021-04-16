package com.example.CarInfoSys.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.CarInfoSys.Entities.Car;
import com.example.CarInfoSys.Services.CarService;

@RestController
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars/{name}")
    private Car getCar(@PathVariable String name) {
        return carService.getCarDetails(name);
    }

}
