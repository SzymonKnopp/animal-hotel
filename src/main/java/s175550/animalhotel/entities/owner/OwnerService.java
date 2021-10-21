package s175550.animalhotel.entities.owner;

import lombok.AllArgsConstructor;
import s175550.animalhotel.Service;
import s175550.animalhotel.UserInterface;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class OwnerService implements Service<Owner> {
    private final OwnerRepository repository;

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

    public Owner ownerFromUI(UserInterface ui) throws NumberFormatException {
        List<Owner> owners = this.findAll();
        for (int i = 0; i < owners.size(); i++) {
            ui.getPrint().println((i + 1) + " - " + owners.get(i).toString());
        }
        int index = Integer.parseInt(ui.getScanner().nextLine()) - 1;
        if (index < 0 || index >= owners.size()) {
            throw new NumberFormatException("owner index outside of bounds");
        }
        return owners.get(index);
    }
}
