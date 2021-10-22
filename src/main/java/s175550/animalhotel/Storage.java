package s175550.animalhotel;

import lombok.Getter;
import org.springframework.stereotype.Component;
import s175550.animalhotel.entities.animal.Animal;
import s175550.animalhotel.entities.owner.Owner;

import java.util.HashMap;

@Component
@Getter
public class Storage {
    private final HashMap<Integer, Owner> owners;
    private final HashMap<Integer, Animal> animals;

    public Storage() {
        owners = new HashMap<>();
        animals = new HashMap<>();

        DataInitializer.initializeData(this);
    }
}
