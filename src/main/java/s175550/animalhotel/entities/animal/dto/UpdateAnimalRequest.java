package s175550.animalhotel.entities.animal.dto;

import lombok.Builder;
import lombok.Getter;
import s175550.animalhotel.entities.Gender;
import s175550.animalhotel.entities.animal.Species;
import s175550.animalhotel.entities.owner.Owner;

@Getter
@Builder
public class UpdateAnimalRequest {
    private String name;
    private Species species;
    private Gender gender;
    private Owner owner;


}
