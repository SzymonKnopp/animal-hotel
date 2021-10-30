package s175550.animalhotel;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import s175550.animalhotel.owner.Gender;
import s175550.animalhotel.owner.Owner;
import s175550.animalhotel.owner.OwnerService;

import javax.annotation.PostConstruct;

@AllArgsConstructor
@Component
public class DataInitializer {
    private final OwnerService ownerService;

    @PostConstruct
    public void initialize() {
        ownerService.save(Owner.builder()
                .name("Maniuś")
                .surname("Jucewicz")
                .gender(Gender.FEMALE)
                .build());

        ownerService.save(Owner.builder()
                .name("Rozuś")
                .surname("Karolczak")
                .gender(Gender.FEMALE)
                .build());

        ownerService.save(Owner.builder()
                .name("Nataluś")
                .surname("Jensko")
                .gender(Gender.FEMALE)
                .build());

        ownerService.save(Owner.builder()
                .name("Nataluś")
                .surname("Cyrklaff")
                .gender(Gender.FEMALE)
                .build());

        ownerService.save(Owner.builder()
                .name("Bognuś")
                .surname("Gondek")
                .gender(Gender.FEMALE)
                .build());

        ownerService.save(Owner.builder()
                .name("Krzysiunio")
                .surname("Mężczyzna")
                .gender(Gender.MALE)
                .build());
    }
}
