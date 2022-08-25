package dat3.carsRus.repository;

import dat3.carsRus.entity.Member;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    private static String memberA;
    private static String memberB;

    @BeforeAll
    public static void setUpData(@Autowired MemberRepository memberRepository){
        Member m1 = new Member("Bob", "farlig", "bob@bob.com", "Bob", "Bobsen", "Enghavevej", "København", 2450, true, 3);
        Member m2 = new Member("Janne", "sikker", "janne@janne.com", "Janne", "Jannesen", "Finsensvej", "Fredesriksberg", 2000, true, 2);
        memberRepository.save(m1);
        memberRepository.save(m2);

        memberA = m1.getEmail();
        memberB = m2.getEmail();
    }


    @Test
    public void testFindByEmail(){
        Member found = memberRepository.getMemberByEmail("janne@janne.com");

        assertEquals(memberB, found.getEmail());
        assertEquals(memberA, "bob@bob.com");

    }

}