package s175550.animalhotel.entities.animal;

import lombok.AllArgsConstructor;
import s175550.animalhotel.Service;
import s175550.animalhotel.entities.owner.Owner;
import s175550.animalhotel.entities.owner.OwnerService;
import s175550.animalhotel.entities.owner.dto.GetOwnerResponse;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class AnimalService implements Service<Animal> {
    private final AnimalRepository repository;
    private final OwnerService ownerService;

    public void save(Animal animal){
        repository.save(animal);
    }

    public Optional<Animal> find(Integer id) {
        return repository.findById(id);
    }

    public List<Animal> findAll() {
        return repository.findAll();
    }

    public void delete(Integer key) {
        repository.deleteById(key);
    }

    public void delete(Animal animalToDelete) { repository.delete(animalToDelete);}

    public List<Animal> getAllOwnedBy(Owner owner) {
        return repository.getAllByOwner(owner);
    }

    public Function<Integer, Owner> idToOwnerMapper() {
        return (id) -> {
            Optional<Owner> owner = ownerService.find(id);
            if (owner.isEmpty()) throw new IllegalArgumentException("owner with desired id not found");
            return owner.get();
        };
    }

    public Optional<GetOwnerResponse> fetchFromOwnerServiceById(int id) {
        return ownerService.fetchFromOwnerServiceById(id);
    }
}
