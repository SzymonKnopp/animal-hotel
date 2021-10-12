package s175550.animalhotel;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

@AllArgsConstructor
public class Repository<ItemType extends ClassCopyableBySerialization<ItemType>> {
    private final HashMap<Integer, ItemType> storage;

    public void add(Integer key, ItemType entity) throws IllegalArgumentException {
        if(storage.containsKey(key)) {
            throw new IllegalArgumentException("attempted insertion of duplicate key");
        }
        storage.put(key, entity);
    }

    Optional<ItemType> get(Integer key) {
        return Optional.ofNullable(storage.get(key).deepCopy()); //TODO: check if deepCopy works fine
    }

    ArrayList<ItemType> getAll() {
        ArrayList<ItemType> result = new ArrayList<>();
        storage.values().forEach(item -> result.add(item.deepCopy())); //TODO: check if deepCopy works fine
        return result;
    }

    void delete(Integer key) {
        storage.remove(key);
    }
}
