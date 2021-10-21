package s175550.animalhotel;

import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository<EntityType> extends JpaRepository<EntityType, Integer> {

}
