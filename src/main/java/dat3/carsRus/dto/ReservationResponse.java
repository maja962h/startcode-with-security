package dat3.carsRus.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.carsRus.entity.Reservation;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class ReservationResponse {

    private int resId;
    private String memberUsername;
    private int carId;
    private String carBrand;

    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate rentalDate;

    public ReservationResponse(Reservation r, boolean includeAll){
        this.memberUsername = r.getMember().getUsername();
        this.carId = r.getCar().getId();
        this.carBrand = r.getCar().getBrand();
        this.rentalDate = r.getRentalDate();
        if(includeAll){
            this.resId = r.getReservationID();
        }
    }

}
