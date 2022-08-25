package dat3.carsRus.entity;

import dat3.security.entity.UserWithRoles;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Member extends UserWithRoles {

    @Column(nullable = false, length = 50)
    private String firstName;
    @Column(nullable = false, length = 50)
    private String lastName;
    @Column(nullable = false, length = 150)
    private String street;
    @Column(nullable = false, length = 100)
    private String city;
    @Column(nullable = false, length = 4)
    private int zip;
    @Column(nullable = false)
    private boolean approved;
    @Column(nullable = false, length = 1)
    private int ranking;


    public Member(String user, String password, String email, String firstName, String lastName, String street, String city, int zip, boolean approved, int ranking) {
        super(user, password, email);
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.approved = approved;
        this.ranking = ranking;
    }

    public Member() {
    }


}
