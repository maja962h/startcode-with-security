package dat3.carsRus.repository;

import dat3.carsRus.entity.Car;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class CarRepositoryTest {

    @Autowired
    CarRepository carRepository;

    private static int car1;
    private static String car2;

    @BeforeAll
    static void setUpData(@Autowired CarRepository carRepository){
        Car c1 = new Car("Toyota", "Aygo", 350, 25.0);
        Car c2 = new Car("Audi", "A6", 600, 30.5);
        carRepository.save(c1);
        carRepository.save(c2);

        car1 = c1.getCarID();
        car2 = c2.getBrand();
    }


    @Test
    void findCarByBrand() {
        List<Car> cars = carRepository.findCarByBrand("Toyota");
        assertEquals(1, cars.size());
    }

    @Test
    void findCarsByPricePrDayBetween() {
        List<Car> cars = carRepository.findCarsByPricePrDayBetween(300, 700);
        assertEquals(2, cars.size());

        cars = carRepository.findCarsByPricePrDayBetween(200, 500);
        assertEquals(1, cars.size());

        cars = carRepository.findCarsByPricePrDayBetween(700, 1000);
        assertEquals(0, cars.size());

    }
}