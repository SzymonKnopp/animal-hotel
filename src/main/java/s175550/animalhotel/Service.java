package s175550.animalhotel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Optional;

public interface Service<EntityType extends Serializable> {
    void save(EntityType entity);

    void save(Integer key, EntityType entity);

    Optional<EntityType> get(Integer key);

    ArrayList<EntityType> getAll();

    void delete(Integer key);

    void delete(EntityType entity);
}