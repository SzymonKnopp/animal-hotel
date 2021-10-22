package s175550.animalhotel.entities.animal;

import lombok.NoArgsConstructor;
import s175550.animalhotel.Repository;
import s175550.animalhotel.entities.owner.Owner;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@org.springframework.stereotype.Repository
public class AnimalRepository extends Repository<Animal> {

    public List<Animal> getAllByOwner(Owner owner) {
        return this.findAll().stream().filter(animal -> animal.getOwner().equals(owner)).collect(Collectors.toList());
    }
}
