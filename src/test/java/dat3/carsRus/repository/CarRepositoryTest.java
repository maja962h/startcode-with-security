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


    @BeforeAll
    static void setUpData(@Autowired CarRepository carRepository){

    }


    @Test
    void findCarByBrand() {

    }

    @Test
    void findCarsByPricePrDayBetween() {


    }

}