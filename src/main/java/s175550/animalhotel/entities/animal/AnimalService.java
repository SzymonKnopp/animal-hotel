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
    public void save(Animal animal){
        repository.save(animal);
    }

    public Optional<Animal> find(Integer id) {
        return repository.findById(id);
    }

    public List<Animal> findAll() {
        return repository.findAll();
    }

    public void delete(Integer key) {
        repository.deleteById(key);
    }

    public void delete(Animal animalToDelete) { repository.delete(animalToDelete);}

    public List<Animal> getAllOwnedBy(Owner owner) {
        return repository.getAllByOwner(owner);
    }

    public Animal animalFromUI(UserInterface ui) throws NumberFormatException {
        List<Animal> animals = this.findAll();
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
