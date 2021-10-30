package s175550.animalhotel.entities.owner.dto;

import lombok.Builder;
import lombok.Getter;
import s175550.animalhotel.entities.owner.Owner;

@Getter
@Builder
public class UpdateOwnerRequest {
    private String name;
    private String surname;

    public Owner updatedOwner(Owner original) {
        return Owner.builder()
                .id(original.getId())
                .name(name != null ? name : original.getName())
                .surname(surname != null ? surname : original.getSurname())
                .build();
    }
}
