package s175550.animalhotel.repository;

import s175550.animalhotel.Repository;
import s175550.animalhotel.model.animal.Animal;
import s175550.animalhotel.model.owner.Owner;

import java.util.List;

@org.springframework.stereotype.Repository
public interface AnimalRepository extends Repository<Animal> {
    List<Animal> getAllByOwner(Owner owner);
}