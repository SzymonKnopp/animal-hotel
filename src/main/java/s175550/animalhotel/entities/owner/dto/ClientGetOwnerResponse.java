package s175550.animalhotel.entities.owner.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import s175550.animalhotel.entities.owner.Owner;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ClientGetOwnerResponse {
    private final int id;
    private final String name;
    private final String surname;

    public Owner toEntity() {
        return Owner.builder()
                .id(id)
                .name(name)
                .surname(surname)
                .build();
    }
}
