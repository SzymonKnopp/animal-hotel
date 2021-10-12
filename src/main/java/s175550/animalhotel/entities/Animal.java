package s175550.animalhotel.entities;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Getter
public class Animal implements Serializable {
    private final String name;
    private final Species species;
    private final Gender gender;
    private final Owner owner;
}
