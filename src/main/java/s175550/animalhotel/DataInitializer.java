package s175550.animalhotel;

import org.springframework.stereotype.Component;
import s175550.animalhotel.entities.Gender;
import s175550.animalhotel.entities.animal.Animal;
import s175550.animalhotel.entities.animal.Species;
import s175550.animalhotel.entities.owner.Owner;

import java.util.HashMap;

@Component
public class DataInitializer {
    private static final HashMap<Integer, Owner> owners;
    private static final HashMap<Integer, Animal> animals;

    static {
        owners = new HashMap<>();
        animals = new HashMap<>();

        owners.put(0, Owner.builder().name("Maniuś").surname("Jucewicz").gender(Gender.FEMALE).build());
        owners.put(1, Owner.builder().name("Rozuś").surname("Karolczak").gender(Gender.FEMALE).build());
        owners.put(2, Owner.builder().name("Nataluś").surname("Jensko").gender(Gender.FEMALE).build());
        owners.put(3, Owner.builder().name("Nataluś").surname("Cyrklaff").gender(Gender.FEMALE).build());
        owners.put(4, Owner.builder().name("Bognuś").surname("Gondek").gender(Gender.FEMALE).build());
        owners.put(5, Owner.builder().name("Krzysiunio").surname("Mężczyzna").gender(Gender.MALE).build());

        animals.put(0, Animal.builder().name("Bonifacy").species(Species.CAT).gender(Gender.MALE).owner(owners.get(4)).build());
        animals.put(1, Animal.builder().name("Bolesław Krzywousty").species(Species.WOMBAT).gender(Gender.MALE).owner(owners.get(0)).build());
        animals.put(2, Animal.builder().name("Korek").species(Species.GUINEA_PIG).gender(Gender.MALE).owner(owners.get(0)).build());
        animals.put(3, Animal.builder().name("Krzysiu").species(Species.GUINEA_PIG).gender(Gender.MALE).owner(owners.get(3)).build());
        animals.put(4, Animal.builder().name("Epilepsja").species(Species.PARROT).gender(Gender.FEMALE).owner(owners.get(2)).build());
        animals.put(5, Animal.builder().name("Nidhogg").species(Species.SNAKE).gender(Gender.MALE).owner(owners.get(1)).build());
    }

    public static void initializeData(Storage storage) {
        storage.getOwners().putAll(owners);
        storage.getAnimals().putAll(animals);
    }
}
