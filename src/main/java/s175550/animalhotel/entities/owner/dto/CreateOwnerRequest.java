package s175550.animalhotel.entities.owner.dto;

import lombok.Builder;
import lombok.Getter;
import s175550.animalhotel.entities.Gender;
import s175550.animalhotel.entities.owner.Owner;

@Getter
@Builder
public class CreateOwnerRequest {
    private final int id;
    private final String name;
    private final String surname;

    public Owner toEntity() {
        return Owner.builder().id(id).name(name).surname(surname).build();
    }
}
