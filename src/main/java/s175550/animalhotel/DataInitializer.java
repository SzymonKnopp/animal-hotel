package s175550.animalhotel;

import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import s175550.animalhotel.entities.Gender;
import s175550.animalhotel.entities.animal.Animal;
import s175550.animalhotel.entities.animal.AnimalService;
import s175550.animalhotel.entities.animal.Species;
import s175550.animalhotel.entities.owner.Owner;
import s175550.animalhotel.entities.owner.OwnerService;

import javax.annotation.PostConstruct;
import java.util.Optional;

@AllArgsConstructor
@Component
public class DataInitializer {
    private final OwnerService ownerService;
    private final AnimalService animalService;

    @PostConstruct
    public void initialize() throws NotFoundException {
        ownerService.fetchAllFromOwnerService().forEach(ownerService::save);

        animalService.save(Animal.builder()
                .name("Bonifacy")
                .species(Species.CAT)
                .gender(Gender.MALE)
                .owner(findByFullNameOrThrow("Maniuś", "Jucewicz"))
                .build());

        animalService.save(Animal.builder()
                .name("Bolesław Krzywousty")
                .species(Species.WOMBAT)
                .gender(Gender.MALE)
                .owner(findByFullNameOrThrow("Maniuś", "Jucewicz"))
                .build());

        animalService.save(Animal.builder()
                .name("Korek")
                .species(Species.GUINEA_PIG)
                .gender(Gender.MALE)
                .owner(findByFullNameOrThrow("Maniuś", "Jucewicz"))
                .build());

        animalService.save(Animal.builder()
                .name("Krzysiu")
                .species(Species.GUINEA_PIG)
                .gender(Gender.MALE)
                .owner(findByFullNameOrThrow("Nataluś", "Cyrklaff"))
                .build());

        animalService.save(Animal.builder()
                .name("Epilepsja")
                .species(Species.PARROT)
                .gender(Gender.FEMALE)
                .owner(findByFullNameOrThrow("Nataluś", "Jensko"))
                .build());

        animalService.save(Animal.builder()
                .name("Nidhogg")
                .species(Species.SNAKE)
                .gender(Gender.MALE)
                .owner(findByFullNameOrThrow("Rozuś", "Karolczak"))
                .build());
    }

    private Owner findByFullNameOrThrow(String name, String surname) throws NotFoundException {
        Optional<Owner> ownerOptional = ownerService.findByFullName(name, surname);

        if (ownerOptional.isPresent()) {
            return ownerOptional.get();
        }
        else {
            throw new NotFoundException("owner " + name + " " + surname + " not found");
        }
    }
}
