package s175550.animalhotel.entities.animal;


import org.springframework.stereotype.Repository;
import s175550.animalhotel.CloningUtility;
import s175550.animalhotel.entities.owner.Owner;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class AnimalRepository{
    private final HashMap<Integer, Animal> storage;

    public AnimalRepository() {
        storage = new HashMap<>();
    }

    public void save(Animal entity) throws IllegalArgumentException {
        int key = storage.size();
        if(storage.containsKey(key)) {
            throw new IllegalArgumentException("attempted insertion of duplicate key");
        }
        storage.put(key, entity);
    }

    public Optional<Animal> findById(Integer key) {
        return Optional.ofNullable(CloningUtility.clone(storage.get(key)));
    }

    public List<Animal> findAll() {
        List<Animal> result = new ArrayList<>();
        storage.values().forEach(item -> result.add(CloningUtility.clone(item)));
        return result;
    }

    public void deleteById(Integer key) {
        storage.remove(key);
    }

    public void delete(Animal entityToDelete) {
        List<Integer> keysToDelete = storage.entrySet().stream()
                .filter(entry -> entry.getValue().equals(entityToDelete))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        if (keysToDelete.size() == 1) this.deleteById(keysToDelete.get(0));
    }

    public List<Animal> getAllByOwner(Owner owner) {
        return this.findAll().stream().filter(animal -> animal.getOwner().equals(owner)).collect(Collectors.toList());
    }
}
