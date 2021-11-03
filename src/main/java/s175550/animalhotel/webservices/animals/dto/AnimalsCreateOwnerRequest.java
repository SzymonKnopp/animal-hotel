package s175550.animalhotel.webservices.animals.dto;

import lombok.Builder;
import lombok.Getter;
import s175550.animalhotel.owner.Owner;

@Getter
@Builder
public class AnimalsCreateOwnerRequest {
    private int id;
    private String name;
    private String surname;

    public static AnimalsCreateOwnerRequest fromEntity(Owner owner) {
        return AnimalsCreateOwnerRequest.builder()
                .id(owner.getId())
                .name(owner.getName())
                .surname(owner.getSurname())
                .build();
    }
}
