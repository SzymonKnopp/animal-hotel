package s175550.animalhotel.entities.owner.dto;

import lombok.Builder;
import lombok.Getter;
import s175550.animalhotel.entities.Gender;

@Getter
@Builder
public class UpdateOwnerRequest {
    private String name;
    private String surname;
    private Gender gender;
}
