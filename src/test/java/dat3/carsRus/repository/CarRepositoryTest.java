package dat3.carsRus.repository;

import dat3.carsRus.entity.Car;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class CarRepositoryTest {

    @Autowired
    CarRepository carRepository;

    private static int car1;
    private static String car2;

    @BeforeAll
    public static void setUpData(@Autowired CarRepository carRepository){
        Car c1 = new Car("Toyota", "Aygo", 96000, 20);
        Car c2 = new Car("Audi", "A6", 300000, 30);
        carRepository.save(c1);
        carRepository.save(c2);

        car1 = c1.getCarID();
        car2 = c2.getBrand();
    }


    @Test
    public void testFindById(){
        Car found = carRepository.findById(car1).get();
        assertEquals(car1, found.getCarID());

    }

    @Test
    public void testFindByBrand(){
        Car found = carRepository.getCarByBrand(car2);
        assertEquals(car2, found.getBrand());

    }


}