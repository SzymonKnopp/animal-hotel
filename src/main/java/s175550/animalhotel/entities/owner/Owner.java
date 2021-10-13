package s175550.animalhotel.entities.owner;

import lombok.Builder;
import lombok.Getter;
import s175550.animalhotel.entities.Gender;

import java.io.Serializable;

@Builder
@Getter
public class Owner implements Serializable {
    private final String name;
    private final String surname;
    private final Gender gender;
}
