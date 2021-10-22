package s175550.animalhotel.entities.owner;


import org.springframework.beans.factory.annotation.Autowired;
import s175550.animalhotel.Repository;
import s175550.animalhotel.Storage;

@org.springframework.stereotype.Repository
public class OwnerRepository extends Repository<Owner> {
    @Autowired
    public OwnerRepository(Storage storage) {
        super(storage.getOwners());
    }
}
