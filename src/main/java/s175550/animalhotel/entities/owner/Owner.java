package s175550.animalhotel.entities.owner;

import lombok.*;
import s175550.animalhotel.entities.Gender;
import s175550.animalhotel.entities.animal.Animal;

import javax.persistence.*;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString

@Entity
@Table(name = "owners")
public class Owner implements Serializable {
    @ToString.Exclude
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String surname;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ToString.Exclude
    @OneToMany(mappedBy = "owner")
    @Column(name = "owned_animals")
    private List<Animal> ownedAnimals;


    private Owner(String name, String surname, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
    }
}
