package s175550.animalhotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import s175550.animalhotel.model.owner.Owner;
import s175550.animalhotel.model.owner.dto.GetAllOwnersResponse;
import s175550.animalhotel.model.owner.dto.GetOwnerResponse;
import s175550.animalhotel.service.OwnerService;

import java.util.Optional;

@RestController
@RequestMapping("api/owners")
public class OwnerController {
    private final OwnerService ownerService;

    @Autowired //TODO: what if no autowired?
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

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
