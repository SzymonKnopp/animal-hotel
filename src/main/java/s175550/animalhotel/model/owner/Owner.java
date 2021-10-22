package s175550.animalhotel.model.owner;

import lombok.*;
import s175550.animalhotel.model.Gender;
import s175550.animalhotel.model.animal.Animal;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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
    @GeneratedValue
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
