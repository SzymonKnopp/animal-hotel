package s175550.animalhotel.entities.animal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import s175550.animalhotel.entities.owner.Owner;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    List<Animal> getAllByOwner(Owner owner);
}