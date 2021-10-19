package s175550.animalhotel.entities.owner;

import lombok.AllArgsConstructor;
import s175550.animalhotel.Service;
import s175550.animalhotel.UserInterface;

import java.util.ArrayList;
import java.util.Optional;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class OwnerService implements Service<Owner> {
    private final OwnerRepository repository;

    public void add(Owner owner) {
        this.add(this.getAll().size(), owner);
    }

    public void add(Integer key, Owner owner) throws IllegalArgumentException {
        repository.add(key, owner);
    }

    public Optional<Owner> get(Integer key) {
        return repository.get(key);
    }

    public ArrayList<Owner> getAll() {
        return repository.getAll();
    }

    public void delete(Integer key) {
        repository.delete(key);
    }

    public void delete(Owner ownerToDelete) {
        repository.delete(ownerToDelete);
    }

    public Owner ownerFromUI(UserInterface ui) throws NumberFormatException {
        ArrayList<Owner> owners = this.getAll();
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
