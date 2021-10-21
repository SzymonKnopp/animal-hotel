package s175550.animalhotel.entities.animal;

import lombok.*;
import s175550.animalhotel.UserInterface;
import s175550.animalhotel.entities.Gender;
import s175550.animalhotel.entities.owner.Owner;
import s175550.animalhotel.entities.owner.OwnerService;

import javax.persistence.*;
import java.io.PrintStream;
import java.io.Serializable;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString

@Entity
@Table(name = "animals")
public class Animal implements Serializable {
    @ToString.Exclude
    @Id
    @GeneratedValue
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

    public static Animal createAnimalFromUI(UserInterface ui, OwnerService ownerService) throws NumberFormatException {
        PrintStream print = ui.getPrint();

        print.println("Name:");
        String name = ui.getScanner().nextLine();

        print.println("Species:");
        Species species = Species.fromUI(ui);

        print.println("Gender:");
        Gender gender = Gender.fromUI(ui);

        print.println("Owner:");
        Owner owner = ownerService.ownerFromUI(ui);

        return new Animal(name, species, gender, owner);
    }
}