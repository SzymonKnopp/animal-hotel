package s175550.animalhotel;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import s175550.animalhotel.entities.animal.AnimalRepository;
import s175550.animalhotel.entities.animal.AnimalService;
import s175550.animalhotel.entities.owner.OwnerRepository;
import s175550.animalhotel.entities.owner.OwnerService;

@Component
public class Main implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        Storage storage = new Storage();
        DataInitializer.initializeData(storage);

        OwnerService ownerService = new OwnerService(new OwnerRepository(storage));
        AnimalService animalService = new AnimalService(new AnimalRepository(storage));

    }
}
