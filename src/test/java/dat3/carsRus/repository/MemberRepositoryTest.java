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


    @BeforeAll
    public static void setUpData(@Autowired MemberRepository memberRepository){

    }


    @Test
    public void testFindByEmail(){


    }

}