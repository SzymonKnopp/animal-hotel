package s175550.animalhotel.entities.owner;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import s175550.animalhotel.entities.owner.dto.GetAllOwnersResponse;
import s175550.animalhotel.entities.owner.dto.GetOwnerResponse;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("api/owners")
public class OwnerController {
    private final OwnerService ownerService;

    @GetMapping
    public ResponseEntity<GetAllOwnersResponse> getAllOwners() {
        return ResponseEntity.ok(
                GetAllOwnersResponse.fromEntities(
                        ownerService.findAll()
                )
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<GetOwnerResponse> getOwnerById(@PathVariable("id") int id) {
        Optional<Owner> owner = ownerService.find(id);

        return owner.isPresent() ?
                ResponseEntity.ok(GetOwnerResponse.fromEntity(owner.get())) :
                ResponseEntity.notFound().build();
    }
}
