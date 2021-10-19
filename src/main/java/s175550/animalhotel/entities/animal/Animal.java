package s175550.animalhotel.entities.animal;

import lombok.*;
import s175550.animalhotel.UserInterface;
import s175550.animalhotel.entities.Gender;
import s175550.animalhotel.entities.owner.Owner;
import s175550.animalhotel.entities.owner.OwnerService;

import java.io.PrintStream;
import java.io.Serializable;

@Builder
@AllArgsConstructor (access = AccessLevel.PRIVATE)
@Getter
@ToString
@EqualsAndHashCode
public class Animal implements Serializable {
    private final String name;
    private final Species species;
    private final Gender gender;
    private final Owner owner;

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