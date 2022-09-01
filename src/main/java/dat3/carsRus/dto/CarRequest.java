package dat3.carsRus.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarRequest {

    int id;

    private String brand;

    private String model;

    double pricePrDay;

    double bestDiscount;



}

