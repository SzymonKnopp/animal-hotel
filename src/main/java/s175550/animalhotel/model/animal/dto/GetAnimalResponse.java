package s175550.animalhotel.model.animal.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import s175550.animalhotel.model.Gender;
import s175550.animalhotel.model.animal.Animal;
import s175550.animalhotel.model.animal.Species;
import s175550.animalhotel.model.owner.dto.GetOwnerResponse;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetAnimalResponse {
    private final String name;
    private final Species species;
    private final Gender gender;
    private final GetOwnerResponse owner;

    public static GetAnimalResponse fromEntity(Animal animalEntity) {
        return new GetAnimalResponse(
                animalEntity.getName(),
                animalEntity.getSpecies(),
                animalEntity.getGender(),
                GetOwnerResponse.fromEntity(animalEntity.getOwner())
        );
    }
}
