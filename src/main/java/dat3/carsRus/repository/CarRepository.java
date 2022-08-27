package dat3.carsRus.repository;

import dat3.carsRus.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {

    List<Car> findCarByBrand(String Brand);

    List<Car> findCarsByPricePrDayBetween(double min, double max);

}
