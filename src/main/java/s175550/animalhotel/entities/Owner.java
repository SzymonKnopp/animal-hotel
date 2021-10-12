package s175550.animalhotel.entities;

import lombok.Builder;
import lombok.Getter;
import s175550.animalhotel.ClassCopyableBySerialization;

@Builder
@Getter
public class Owner extends ClassCopyableBySerialization<Owner> {
    private final String name;
    private final String surname;
    private final Gender gender;
}
