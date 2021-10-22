package s175550.animalhotel.entities.animal;

import lombok.AllArgsConstructor;
import s175550.animalhotel.Service;
import s175550.animalhotel.UserInterface;
import s175550.animalhotel.entities.owner.Owner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class AnimalService implements Service<Animal> {
    private final AnimalRepository repository;

    public void save(Animal animal) {
        this.save(this.getAll().size(), animal);
    }

    public void save(Integer key, Animal animal) throws IllegalArgumentException {
        repository.add(key, animal);
    }

    public Optional<Animal> get(Integer key) {
        return repository.get(key);
    }

    public ArrayList<Animal> getAll() {
        return repository.getAll();
    }

    public void delete(Integer key) {
        repository.delete(key);
    }

    public void delete(Animal animalToDelete) { repository.delete(animalToDelete);}

    public List<Animal> getAllOwnedBy(Owner owner) {
        return repository.getAllOwnedBy(owner);
    }

    public Animal animalFromUI(UserInterface ui) throws NumberFormatException {
        ArrayList<Animal> animals = this.getAll();
        for (int i = 0; i < animals.size(); i++) {
            ui.getPrint().println((i + 1) + " - " + animals.get(i).toString());
        }
        int index = Integer.parseInt(ui.getScanner().nextLine()) - 1;
        if (index < 0 || index >= animals.size()) {
            throw new NumberFormatException("animal index outside of bounds");
        }
        return animals.get(index);
    }
}
