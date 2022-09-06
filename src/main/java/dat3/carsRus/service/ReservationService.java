package dat3.carsRus.service;

import dat3.carsRus.entity.Car;
import dat3.carsRus.entity.Member;
import dat3.carsRus.entity.Reservation;
import dat3.carsRus.repository.CarRepository;
import dat3.carsRus.repository.MemberRepository;
import dat3.carsRus.repository.ReservationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@Service
public class ReservationService {

    private ReservationRepository reservationRepository;
    private MemberRepository memberRepository;
    private CarRepository carRepository;

    public ReservationService(ReservationRepository reservationRepository, MemberRepository memberRepository, CarRepository carRepository) {
        this.reservationRepository = reservationRepository;
        this.memberRepository = memberRepository;
        this.carRepository = carRepository;
    }

    public void reserveCar(String memberId, int carId, LocalDate date){
        boolean exists = reservationRepository.existsByCar_IdAndRentalDate(carId, date);

        if (exists){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "car is already reserved for this date");
        }

        Member member = memberRepository.findById(memberId).orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "user not found"));
        Car car = carRepository.findById(carId).orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "car not found"));

        Reservation res = new Reservation(member, car, date);
        reservationRepository.save(res);
    }

}
