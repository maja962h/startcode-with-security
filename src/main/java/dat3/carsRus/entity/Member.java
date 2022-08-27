package dat3.carsRus.entity;

import dat3.security.entity.UserWithRoles;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member extends UserWithRoles {

    @Column(length = 50)
    private String firstName;
    @Column(length = 50)
    private String lastName;
    @Column(length = 150)
    private String street;
    @Column(length = 100)
    private String city;
    @Column(length = 4)
    private int zip;
    private boolean approved;
    @Column(length = 1)
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


}
