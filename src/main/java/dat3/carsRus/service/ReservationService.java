package dat3.carsRus.service;

import dat3.carsRus.dto.ReservationResponse;
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
import java.util.List;
import java.util.stream.Collectors;

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

        Member member = memberRepository.findById(memberId).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found"));

        Car car = carRepository.findById(carId).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Car not found"));

        if(reservationRepository.existsByCar_IdAndRentalDate(carId, date)){
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, "Car not available");
        }

        Reservation reservation = new Reservation(member, car, date);
        reservationRepository.save(reservation);

    }

    public List<ReservationResponse> getReservations() {
        List<Reservation> reservations = reservationRepository.findAll();

        List<ReservationResponse> responses = reservations.stream().map(reservation -> new ReservationResponse(reservation, false)).collect(Collectors.toList());

        return responses;

    }
}
