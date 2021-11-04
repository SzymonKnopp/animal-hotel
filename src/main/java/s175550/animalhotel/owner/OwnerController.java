package s175550.animalhotel.owner;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import s175550.animalhotel.webservices.animals.AnimalsRestClient;
import s175550.animalhotel.owner.dto.CreateOwnerRequest;
import s175550.animalhotel.owner.dto.GetAllOwnersResponse;
import s175550.animalhotel.owner.dto.GetOwnerResponse;
import s175550.animalhotel.owner.dto.UpdateOwnerRequest;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("api/owners")
public class OwnerController {
    private final OwnerService ownerService;
    private final AnimalsRestClient animalsRestClient;

    @GetMapping
    public ResponseEntity<GetAllOwnersResponse> getAllOwners() {
        return ResponseEntity.ok(
                GetAllOwnersResponse.fromEntities(
                        ownerService.findAll()
                )
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<GetOwnerResponse> getOwner(@PathVariable("id") int id) {
        Optional<Owner> owner = ownerService.find(id);

        return owner.isPresent() ?
                ResponseEntity.ok(GetOwnerResponse.fromEntity(owner.get())) :
                ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Void> createOwner(@RequestBody CreateOwnerRequest request, UriComponentsBuilder builder) {
        Owner newOwner = request.toEntity();
        ownerService.save(newOwner);
        animalsRestClient.createOwner(newOwner);
        return ResponseEntity.created(builder.pathSegment("api", "owners", "{id}")
                .buildAndExpand(newOwner.getId()).toUri()).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateOwner(@PathVariable("id") int id, @RequestBody UpdateOwnerRequest request) {
        Optional<Owner> original = ownerService.find(id);
        if (original.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else {
            ownerService.save(request.updatedOwner(original.get()));
            animalsRestClient.updateOwner(id, request);
            return ResponseEntity.accepted().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteOwner(@PathVariable("id") int id) {
        Optional<Owner> ownerToDelete = ownerService.find(id);
        if (ownerToDelete.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else {
            ownerService.delete(id);
            animalsRestClient.deleteOwner(id);
            return ResponseEntity.ok().build();
        }
    }
}
