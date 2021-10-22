package s175550.animalhotel.model.owner.dto;

import lombok.Builder;
import s175550.animalhotel.model.Gender;

@Builder
public class UpdateOwnerRequest {
    private String name;
    private String surname;
    private Gender gender;
}
