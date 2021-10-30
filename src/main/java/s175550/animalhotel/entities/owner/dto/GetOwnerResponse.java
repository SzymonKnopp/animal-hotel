package s175550.animalhotel.entities.owner.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import s175550.animalhotel.entities.Gender;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetOwnerResponse {
    private final int id;
    private final String name;
    private final String surname;
    private final Gender gender;
}
