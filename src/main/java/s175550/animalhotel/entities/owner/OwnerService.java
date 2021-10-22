package s175550.animalhotel.entities.owner;

import lombok.AllArgsConstructor;
import s175550.animalhotel.Service;

import java.util.ArrayList;
import java.util.Optional;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class OwnerService implements Service<Owner> {
    private final OwnerRepository repository;

    public void save(Owner owner) {
        this.save(this.getAll().size(), owner);
    }

    public void save(Integer key, Owner owner) throws IllegalArgumentException {
        repository.add(key, owner);
    }

    public Optional<Owner> get(Integer key) {
        return repository.get(key);
    }

    public ArrayList<Owner> getAll() {
        return repository.getAll();
    }

    public void delete(Integer key) {
        repository.delete(key);
    }

    public void delete(Owner ownerToDelete) {
        repository.delete(ownerToDelete);
    }
}
