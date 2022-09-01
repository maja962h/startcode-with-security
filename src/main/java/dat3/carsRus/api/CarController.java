package dat3.carsRus.api;

import dat3.carsRus.dto.CarRequest;
import dat3.carsRus.dto.CarResponse;
import dat3.carsRus.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    List<CarResponse> getCars(){
        return carService.getCars();
    }

    @GetMapping(path = "/{id}")
    CarResponse findCarById (@PathVariable int id){
        return carService.findCarById(id);
    }

    @PostMapping
    CarResponse addCar(@RequestBody CarRequest body){
        return carService.addCar(body);
    }
}
