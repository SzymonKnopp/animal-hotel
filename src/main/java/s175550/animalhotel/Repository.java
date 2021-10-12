package s175550.animalhotel;

import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

@AllArgsConstructor
public class Repository<ItemType extends Serializable> {
    private final HashMap<Integer, ItemType> storage;

    public void add(Integer key, ItemType entity) throws IllegalArgumentException {
        if(storage.containsKey(key)) {
            throw new IllegalArgumentException("attempted insertion of duplicate key");
        }
        storage.put(key, entity);
    }

    public Optional<ItemType> get(Integer key) {
        return Optional.ofNullable(CloningUtility.clone(storage.get(key)));
    }

    public ArrayList<ItemType> getAll() {
        ArrayList<ItemType> result = new ArrayList<>();
        storage.values().forEach(item -> result.add(CloningUtility.clone(item)));
        return result;
    }

    public void delete(Integer key) {
        storage.remove(key);
    }
}
