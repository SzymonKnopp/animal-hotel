package s175550.animalhotel.entities.owner;

import lombok.*;
import s175550.animalhotel.UserInterface;
import s175550.animalhotel.entities.Gender;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.Scanner;

@Builder
@AllArgsConstructor (access = AccessLevel.PRIVATE)
@Getter
@ToString
@EqualsAndHashCode
public class Owner implements Serializable {
    private final String name;
    private final String surname;
    private final Gender gender;

    public static Owner createOwnerFromUI(UserInterface ui) throws NumberFormatException {
        Scanner scanner = ui.getScanner();
        PrintStream print = ui.getPrint();

        print.println("Name:");
        String name = scanner.nextLine();

        print.println("Surname:");
        String surname = scanner.nextLine();

        print.println("Gender:");
        Gender gender = Gender.fromUI(ui);

        return new Owner(name, surname, gender);
    }
}
