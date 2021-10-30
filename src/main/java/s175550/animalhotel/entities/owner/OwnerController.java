package s175550.animalhotel.entities.owner;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import s175550.animalhotel.entities.owner.dto.CreateOwnerRequest;
import s175550.animalhotel.entities.owner.dto.UpdateOwnerRequest;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("api/owners")
public class OwnerController {
    private final OwnerService ownerService;

    @PostMapping
    public ResponseEntity<Void> createOwner(@RequestBody CreateOwnerRequest request, UriComponentsBuilder builder) {
        Owner newOwner = request.toEntity();
        ownerService.save(newOwner);
        return ResponseEntity.created(builder.pathSegment("api", "owners", "{id}")
                .buildAndExpand(newOwner.getId()).toUri()).build();
    }

    @PatchMapping("{id}")
    public ResponseEntity<Void> updateOwner(@PathVariable("id") int id, @RequestBody UpdateOwnerRequest request) {
        Optional<Owner> original = ownerService.find(id);
        if (original.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else {
            ownerService.save(request.updatedOwner(original.get()));
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
            return ResponseEntity.ok().build();
        }
    }
}
