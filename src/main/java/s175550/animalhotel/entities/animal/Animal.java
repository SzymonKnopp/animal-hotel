package s175550.animalhotel.entities.animal;

import lombok.*;
import s175550.animalhotel.entities.Gender;
import s175550.animalhotel.entities.owner.Owner;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString

@Entity
@Table(name = "animals")
public class Animal implements Serializable {
    @ToString.Exclude
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Species species;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne
    private Owner owner;


    public Animal(String name, Species species, Gender gender, Owner owner) {
        this.name = name;
        this.species = species;
        this.gender = gender;
        this.owner = owner;
    }
}