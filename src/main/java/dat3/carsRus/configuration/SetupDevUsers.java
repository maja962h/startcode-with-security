package dat3.carsRus.configuration;

import dat3.carsRus.entity.Car;
import dat3.carsRus.entity.Member;
import dat3.carsRus.repository.CarRepository;
import dat3.carsRus.repository.MemberRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;
import dat3.security.repository.UserWithRolesRepository;

@Controller
public class SetupDevUsers implements ApplicationRunner {

    UserWithRolesRepository userWithRolesRepository;
    MemberRepository memberRepository;
    CarRepository carRepository;

    public SetupDevUsers(UserWithRolesRepository userWithRolesRepository, MemberRepository memberRepository, CarRepository carRepository) {
        this.userWithRolesRepository = userWithRolesRepository;
        this.memberRepository = memberRepository;
        this.carRepository = carRepository;
    }
    @Override
    public void run(ApplicationArguments args) {
        setupUserWithRoleUsers();
    }


    private void setupUserWithRoleUsers() {
        Member member = new Member("Bob", "farlig", "bob@bob.com", "Bob", "Bobsen", "Enghavevej", "København", 2450, true, 3);
        Member member1 = new Member("Janne", "sikker", "janne@janne.com", "Janne", "Jannesen", "Finsensvej", "Fredesriksberg", 2000, true, 2);
        memberRepository.save(member);
        memberRepository.save(member1);

        Car car = Car.builder()
                .brand("Toyota")
                .model("Aygo")
                .pricePrDay(350)
                .bestDiscount(25.0)
                .build();

        Car car1 = Car.builder()
                .brand("Audi")
                .model("A6")
                .pricePrDay(600)
                .bestDiscount(30.5)
                .build();

        carRepository.save(car);
        carRepository.save(car1);
    }

}
