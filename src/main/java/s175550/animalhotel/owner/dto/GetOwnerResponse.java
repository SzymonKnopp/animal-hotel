package s175550.animalhotel.owner.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import s175550.animalhotel.owner.Gender;
import s175550.animalhotel.owner.Owner;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetOwnerResponse {
    private final int id;
    private final String name;
    private final String surname;
    private final Gender gender;

    public static GetOwnerResponse fromEntity(Owner ownerEntity) {
        return new GetOwnerResponse(
                ownerEntity.getId(),
                ownerEntity.getName(),
                ownerEntity.getSurname(),
                ownerEntity.getGender()
        );
    }
}
