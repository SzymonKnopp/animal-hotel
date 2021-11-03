package s175550.animalhotel.entities.animal;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import s175550.animalhotel.entities.animal.dto.GetAllAnimalsResponse;
import s175550.animalhotel.entities.animal.dto.CreateAnimalRequest;
import s175550.animalhotel.entities.animal.dto.GetAnimalResponse;
import s175550.animalhotel.entities.animal.dto.UpdateAnimalRequest;
import s175550.animalhotel.webservices.owners.dto.OwnersGetOwnerResponse;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("api/animals")
public class AnimalController {
    private final AnimalService animalService;

    @GetMapping
    public ResponseEntity<GetAllAnimalsResponse> getAllAnimals() {
        return ResponseEntity.ok(
                GetAllAnimalsResponse.fromEntities(
                        animalService.findAll()
                )
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<GetAnimalResponse> getAnimal(@PathVariable("id") int id) {
        Optional<Animal> animalOptional = animalService.find(id);

        if (animalOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Animal animal = animalOptional.get();
        Optional<OwnersGetOwnerResponse> ownerResponseOptional =
                animalService.fetchFromOwnerServiceById(animal.getOwner().getId());

        if (ownerResponseOptional.isEmpty()) {
            return ResponseEntity.internalServerError().build();
        }

        return ResponseEntity.ok(GetAnimalResponse.fromEntityAndOwnerResponse(animal, ownerResponseOptional.get()));

    }

    @PostMapping
    public ResponseEntity<Void> createAnimal(@RequestBody CreateAnimalRequest request, UriComponentsBuilder builder) {
        Animal newAnimal = request.toEntity(animalService.idToOwnerMapper());
        animalService.save(newAnimal);
        return ResponseEntity.created(builder.pathSegment("api", "animals", "{id}")
                .buildAndExpand(newAnimal.getId()).toUri()).build();
    }

    @PatchMapping("{id}")
    public ResponseEntity<Void> updateAnimal(@PathVariable("id") int id, @RequestBody UpdateAnimalRequest request) {
        Optional<Animal> original = animalService.find(id);
        if (original.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else {
            animalService.save(request.updatedAnimal(original.get(), animalService.idToOwnerMapper()));
            return ResponseEntity.accepted().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable("id") int id) {
        Optional<Animal> animalToDelete = animalService.find(id);
        if (animalToDelete.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else {
            animalService.delete(id);
            return ResponseEntity.ok().build();
        }
    }
}
