package s175550.animalhotel.entities.animal.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import s175550.animalhotel.entities.Gender;
import s175550.animalhotel.entities.animal.Animal;
import s175550.animalhotel.entities.animal.Species;
import s175550.animalhotel.entities.owner.dto.ClientGetOwnerResponse;
import s175550.animalhotel.entities.owner.dto.GetOwnerResponse;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetAnimalResponse {
    private final int id;
    private final String name;
    private final Species species;
    private final Gender gender;
    private final GetOwnerResponse owner;

    public static GetAnimalResponse fromEntityAndOwnerResponse(Animal animalEntity, GetOwnerResponse owner) {
        return new GetAnimalResponse(
                animalEntity.getId(),
                animalEntity.getName(),
                animalEntity.getSpecies(),
                animalEntity.getGender(),
                owner
        );
    }
}
