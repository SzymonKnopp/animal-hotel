package s175550.animalhotel.model.owner.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import s175550.animalhotel.model.Gender;
import s175550.animalhotel.model.owner.Owner;

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
