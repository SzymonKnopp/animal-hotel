package s175550.animalhotel.entities.owner;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OwnerService {
    private final OwnerRepository repository;

    public void add(Integer key, Owner owner) throws IllegalArgumentException {
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
}
