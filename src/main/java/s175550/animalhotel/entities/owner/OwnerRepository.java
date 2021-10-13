package s175550.animalhotel.entities.owner;


import s175550.animalhotel.Repository;
import s175550.animalhotel.Storage;

@org.springframework.stereotype.Repository
public class OwnerRepository extends Repository<Owner> {
    public OwnerRepository(Storage storage) {
        super(storage.getOwners());
    }
}
