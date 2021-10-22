package s175550.animalhotel.entities.owner;


import org.springframework.stereotype.Repository;
import s175550.animalhotel.CloningUtility;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class OwnerRepository {
    private final HashMap<Integer, Owner> storage;

    public OwnerRepository() {
        storage = new HashMap<>();
    }

    public void save(Owner entity) throws IllegalArgumentException {
        int key = storage.size();
        if(storage.containsKey(key)) {
            throw new IllegalArgumentException("attempted insertion of duplicate key");
        }
        storage.put(key, entity);
    }

    public Optional<Owner> findById(Integer key) {
        return Optional.ofNullable(CloningUtility.clone(storage.get(key)));
    }

    public List<Owner> findAll() {
        List<Owner> result = new ArrayList<>();
        storage.values().forEach(item -> result.add(CloningUtility.clone(item)));
        return result;
    }

    public void deleteById(Integer key) {
        storage.remove(key);
    }

    public void delete(Owner entityToDelete) {
        List<Integer> keysToDelete = storage.entrySet().stream()
                .filter(entry -> entry.getValue().equals(entityToDelete))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        if (keysToDelete.size() == 1) this.deleteById(keysToDelete.get(0));
    }
}