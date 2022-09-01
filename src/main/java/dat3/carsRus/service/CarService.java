package dat3.carsRus.service;

import dat3.carsRus.dto.CarRequest;
import dat3.carsRus.dto.CarResponse;
import dat3.carsRus.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<CarResponse> getCars(){
        return null;
    }

    public CarResponse addCar(CarRequest carRequest){
        return null;
    }

    public CarResponse findCarById (int id){
        return null;
    }

    public void deleteCar(int id){

    }

}
