package dat3.carsRus.dto;

import dat3.carsRus.entity.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarRequest {
    String brand;
    String model;
    double pricePrDay;
    double bestDiscount;

    public CarRequest(Car car){
        this.brand = car.getBrand();
        this.model = car.getModel();
        this.pricePrDay = car.getPricePrDay();
        this.bestDiscount = car.getBestDiscount();
    }

    public static Car getCarEntity(CarRequest cr){
        return Car.builder()
                .brand(cr.brand)
                .model(cr.model)
                .pricePrDay(cr.pricePrDay)
                .bestDiscount(cr.bestDiscount)
                .build();
    }



}

