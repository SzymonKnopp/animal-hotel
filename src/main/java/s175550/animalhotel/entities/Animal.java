package s175550.animalhotel.entities;

import lombok.Builder;
import lombok.Getter;
import s175550.animalhotel.ClassCopyableBySerialization;

@Builder
@Getter
public class Animal extends ClassCopyableBySerialization<Animal> {
    private final String name;
    private final Species species;
    private final Gender gender;
    private final Owner owner;
}
