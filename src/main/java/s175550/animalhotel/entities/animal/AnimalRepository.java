package s175550.animalhotel.entities.animal;

import s175550.animalhotel.Repository;
import s175550.animalhotel.Storage;
import s175550.animalhotel.entities.owner.Owner;

import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Repository
public class AnimalRepository extends Repository<Animal> {
    public AnimalRepository() {
        super(Storage.animals);
    }

    public List<Animal> getAllOwnedBy(Owner owner) {
        return this.getAll().stream().filter(animal -> animal.getOwner().equals(owner)).collect(Collectors.toList());
    }
}
