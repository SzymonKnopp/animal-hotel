package s175550.animalhotel.webservices.owners.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import s175550.animalhotel.entities.owner.Owner;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OwnersGetOwnerResponse {
    private int id;
    private String name;
    private String surname;

    public Owner toEntity() {
        return Owner.builder()
                .id(id)
                .name(name)
                .surname(surname)
                .build();
    }
}
