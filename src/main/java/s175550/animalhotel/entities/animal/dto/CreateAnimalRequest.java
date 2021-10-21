package s175550.animalhotel.entities.animal.dto;

import lombok.Builder;
import s175550.animalhotel.entities.Gender;
import s175550.animalhotel.entities.animal.Animal;
import s175550.animalhotel.entities.animal.Species;
import s175550.animalhotel.entities.owner.Owner;

@Builder
public class CreateAnimalRequest {
    private final String name;
    private final Species species;
    private final Gender gender;
    private final Owner owner;

    public Animal toEntity() {
        return Animal.builder().name(name).species(species).gender(gender).owner(owner).build();
    }
}
