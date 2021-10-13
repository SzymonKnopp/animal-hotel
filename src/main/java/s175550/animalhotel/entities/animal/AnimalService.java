package s175550.animalhotel.entities.animal;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import s175550.animalhotel.entities.owner.Owner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AnimalService {
    private final AnimalRepository repository;

    public void add(Integer key, Animal animal) throws IllegalArgumentException {
        repository.add(key, animal);
    }

    public Optional<Animal> get(Integer key) {
        return repository.get(key);
    }

    public ArrayList<Animal> getAll() {
        return repository.getAll();
    }

    public void delete(Integer key) {
        repository.delete(key);
    }

    public List<Animal> getAllOwnedBy(Owner owner) {
        return repository.getAllOwnedBy(owner);
    }
}
