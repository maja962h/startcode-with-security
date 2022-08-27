package dat3.carsRus.repository;

import dat3.carsRus.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, String> {

    Member findMemberByEmail(String email);

}
