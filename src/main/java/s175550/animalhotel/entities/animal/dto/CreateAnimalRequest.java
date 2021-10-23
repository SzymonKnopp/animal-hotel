package s175550.animalhotel.entities.animal.dto;

import lombok.Builder;
import lombok.Getter;
import s175550.animalhotel.entities.Gender;
import s175550.animalhotel.entities.animal.Animal;
import s175550.animalhotel.entities.animal.Species;
import s175550.animalhotel.entities.owner.Owner;

import java.util.function.Function;

@Getter
@Builder
public class CreateAnimalRequest {
    private final String name;
    private final Species species;
    private final Gender gender;
    private final int ownerId;

    public Animal toEntity(Function<Integer, Owner> ownerFromIdMapper) {
        return Animal.builder()
                .name(name)
                .species(species)
                .gender(gender)
                .owner(ownerFromIdMapper.apply(ownerId))
                .build();
    }
}
