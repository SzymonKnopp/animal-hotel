package s175550.animalhotel.entities.animal.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import s175550.animalhotel.entities.Gender;
import s175550.animalhotel.entities.animal.Animal;
import s175550.animalhotel.entities.animal.Species;
import s175550.animalhotel.entities.owner.dto.GetOwnerResponse;

@Getter
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
