package s175550.animalhotel;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface Service<EntityType extends Serializable> {
    void save(EntityType entity);

    Optional<EntityType> find(Integer key);

    List<EntityType> findAll();

    void delete(Integer key);

    void delete(EntityType entity);
}