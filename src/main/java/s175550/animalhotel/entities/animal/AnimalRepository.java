package s175550.animalhotel.entities.animal;

import s175550.animalhotel.Repository;
import s175550.animalhotel.entities.owner.Owner;

import java.util.List;

@org.springframework.stereotype.Repository
public interface AnimalRepository extends Repository<Animal> {
    List<Animal> getAllByOwner(Owner owner);
}