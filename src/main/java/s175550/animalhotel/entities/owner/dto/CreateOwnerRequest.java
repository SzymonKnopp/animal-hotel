package s175550.animalhotel.entities.owner.dto;

import lombok.Builder;
import s175550.animalhotel.entities.Gender;
import s175550.animalhotel.entities.owner.Owner;

@Builder
public class CreateOwnerRequest {
    private final String name;
    private final String surname;
    private final Gender gender;

    public Owner toEntity() {
        return Owner.builder().name(name).surname(surname).gender(gender).build();
    }
}
