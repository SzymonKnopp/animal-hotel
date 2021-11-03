package s175550.animalhotel.webservices.animals.dto;

import lombok.Builder;
import lombok.Getter;
import s175550.animalhotel.owner.dto.UpdateOwnerRequest;

@Getter
@Builder
public class AnimalsUpdateOwnerRequest {
    private String name;
    private String surname;

    public static AnimalsUpdateOwnerRequest fromUpdateDto(UpdateOwnerRequest request) {
        return AnimalsUpdateOwnerRequest.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .build();
    }
}
