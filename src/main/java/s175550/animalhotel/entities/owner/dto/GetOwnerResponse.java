package s175550.animalhotel.entities.owner.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import s175550.animalhotel.entities.Gender;
import s175550.animalhotel.entities.owner.Owner;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetOwnerResponse {
    private final String name;
    private final String surname;
    private final Gender gender;

    public static GetOwnerResponse fromEntity(Owner ownerEntity) {
        return new GetOwnerResponse(
                ownerEntity.getName(),
                ownerEntity.getSurname(),
                ownerEntity.getGender()
        );
    }
}
