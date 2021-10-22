package s175550.animalhotel;

import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

@org.springframework.stereotype.Repository
public class Repository<EntityType extends Serializable> {
    protected final HashMap<Integer, EntityType> storage;

    public Repository() {
        storage = new HashMap<>();
    }

    public void add(Integer key, EntityType entity) throws IllegalArgumentException {
        if(storage.containsKey(key)) {
            throw new IllegalArgumentException("attempted insertion of duplicate key");
        }
        storage.put(key, entity);
    }

    public Optional<EntityType> get(Integer key) {
        return Optional.ofNullable(CloningUtility.clone(storage.get(key)));
    }

    public ArrayList<EntityType> getAll() {
        ArrayList<EntityType> result = new ArrayList<>();
        storage.values().forEach(item -> result.add(CloningUtility.clone(item)));
        return result;
    }

    public void delete(Integer key) {
        storage.remove(key);
    }

    public void delete(EntityType entityToDelete) {
        List<Integer> keysToDelete = storage.entrySet().stream()
                .filter(entry -> entry.getValue().equals(entityToDelete))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        if (keysToDelete.size() == 1) this.delete(keysToDelete.get(0));
    }
}
