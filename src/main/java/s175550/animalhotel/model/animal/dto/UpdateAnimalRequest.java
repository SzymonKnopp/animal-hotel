package s175550.animalhotel.model.animal.dto;

import lombok.Builder;
import s175550.animalhotel.model.Gender;
import s175550.animalhotel.model.animal.Species;
import s175550.animalhotel.model.owner.Owner;

@Builder
public class UpdateAnimalRequest {
    private String name;
    private Species species;
    private Gender gender;
    private Owner owner;


}
