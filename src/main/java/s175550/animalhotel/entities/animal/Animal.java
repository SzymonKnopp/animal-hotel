package s175550.animalhotel.entities.animal;

import lombok.Builder;
import lombok.Getter;
import s175550.animalhotel.entities.Gender;
import s175550.animalhotel.entities.owner.Owner;

import java.io.Serializable;

@Builder
@Getter
public class Animal implements Serializable {
    private final String name;
    private final Species species;
    private final Gender gender;
    private final Owner owner;
}
