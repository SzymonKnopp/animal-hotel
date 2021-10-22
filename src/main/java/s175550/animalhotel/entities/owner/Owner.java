package s175550.animalhotel.entities.owner;

import lombok.*;
import s175550.animalhotel.entities.Gender;

import java.io.Serializable;

@Builder
@AllArgsConstructor (access = AccessLevel.PRIVATE)
@Getter
@ToString
@EqualsAndHashCode
public class Owner implements Serializable {
    private final String name;
    private final String surname;
    private final Gender gender;
}
