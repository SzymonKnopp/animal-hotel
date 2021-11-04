package s175550.animalhotel.entities.owner.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import s175550.animalhotel.entities.owner.Owner;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class GetOwnerResponse {
    private Integer id;
    private String name;
    private String surname;

    public static GetOwnerResponse fromEntity(Owner owner) {
        return GetOwnerResponse.builder()
                .id(owner.getId())
                .name(owner.getName())
                .surname(owner.getSurname())
                .build();
    }
}
