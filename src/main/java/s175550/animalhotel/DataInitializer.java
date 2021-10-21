package s175550.animalhotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import s175550.animalhotel.entities.Gender;
import s175550.animalhotel.entities.animal.Animal;
import s175550.animalhotel.entities.animal.AnimalService;
import s175550.animalhotel.entities.animal.Species;
import s175550.animalhotel.entities.owner.Owner;
import s175550.animalhotel.entities.owner.OwnerService;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {
    private final OwnerService ownerService;
    private final AnimalService animalService;

    @Autowired //TODO: what if no Autowired?
    public DataInitializer(OwnerService ownerService, AnimalService animalService) {
        this.ownerService = ownerService;
        this.animalService = animalService;
    }

    @PostConstruct
    public void initialize() {
        Owner manius = Owner.builder()
                .name("Maniuś")
                .surname("Jucewicz")
                .gender(Gender.FEMALE)
                .build();
        ownerService.save(manius);

        Owner rozus = Owner.builder()
                .name("Rozuś")
                .surname("Karolczak")
                .gender(Gender.FEMALE)
                .build();
        ownerService.save(rozus);

        Owner natalusJ = Owner.builder()
                .name("Nataluś")
                .surname("Jensko")
                .gender(Gender.FEMALE)
                .build();
        ownerService.save(natalusJ);

        Owner natalusC = Owner.builder()
                .name("Nataluś")
                .surname("Cyrklaff")
                .gender(Gender.FEMALE)
                .build();
        ownerService.save(natalusC);

        Owner bognus = Owner.builder()
                .name("Bognuś")
                .surname("Gondek")
                .gender(Gender.FEMALE)
                .build();
        ownerService.save(bognus);

        Owner krzysiunio = Owner.builder()
                .name("Krzysiunio")
                .surname("Mężczyzna")
                .gender(Gender.MALE)
                .build();
        ownerService.save(krzysiunio);

        animalService.save(Animal.builder()
                .name("Bonifacy")
                .species(Species.CAT)
                .gender(Gender.MALE)
                .owner(manius)
                .build());

        animalService.save(Animal.builder()
                .name("Bolesław Krzywousty")
                .species(Species.WOMBAT)
                .gender(Gender.MALE)
                .owner(manius)
                .build());

        animalService.save(Animal.builder()
                .name("Korek")
                .species(Species.GUINEA_PIG)
                .gender(Gender.MALE)
                .owner(manius)
                .build());

        animalService.save(Animal.builder()
                .name("Krzysiu")
                .species(Species.GUINEA_PIG)
                .gender(Gender.MALE)
                .owner(natalusC)
                .build());

        animalService.save(Animal.builder()
                .name("Epilepsja")
                .species(Species.PARROT)
                .gender(Gender.FEMALE)
                .owner(natalusJ)
                .build());

        animalService.save(Animal.builder()
                .name("Nidhogg")
                .species(Species.SNAKE)
                .gender(Gender.MALE)
                .owner(rozus)
                .build());
    }
}
