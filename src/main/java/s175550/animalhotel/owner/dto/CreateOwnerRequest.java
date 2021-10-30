package s175550.animalhotel.owner.dto;

import lombok.Builder;
import lombok.Getter;
import s175550.animalhotel.owner.Gender;
import s175550.animalhotel.owner.Owner;

@Getter
@Builder
public class CreateOwnerRequest {
    private final String name;
    private final String surname;
    private final Gender gender;

    public Owner toEntity() {
        return Owner.builder().name(name).surname(surname).gender(gender).build();
    }
}
