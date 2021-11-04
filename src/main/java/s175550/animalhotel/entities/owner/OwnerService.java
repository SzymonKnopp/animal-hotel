package s175550.animalhotel.entities.owner;

import lombok.AllArgsConstructor;
import s175550.animalhotel.Service;
import s175550.animalhotel.webservices.owners.OwnerRestClient;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class OwnerService implements Service<Owner> {
    private final OwnerRepository repository;
    private final OwnerRestClient ownerRestClient;

    public void save(Owner owner) {
        repository.save(owner);
    }

    public Optional<Owner> find(Integer id) {
        return repository.findById(id);
    }

    public List<Owner> findAll() {
        return repository.findAll();
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public void delete(Owner ownerToDelete) {
        repository.delete(ownerToDelete);
    }

    public List<Owner> fetchAllFromOwnerService() {
        return ownerRestClient.getAllOwners().toEntities();
    }

    public Optional<Owner> findByFullName(String name, String surname) {
        return repository.findByNameAndSurname(name, surname);
    }
}
