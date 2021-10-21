package s175550.animalhotel.entities.owner.dto;

import lombok.Builder;
import s175550.animalhotel.entities.Gender;

@Builder
public class UpdateOwnerRequest {
    private String name;
    private String surname;
    private Gender gender;
}
