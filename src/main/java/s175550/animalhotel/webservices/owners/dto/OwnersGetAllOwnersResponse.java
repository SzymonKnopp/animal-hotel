package s175550.animalhotel.webservices.owners.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import s175550.animalhotel.entities.owner.Owner;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OwnersGetAllOwnersResponse {
    private List<OwnersGetOwnerResponse> allOwners;

    public List<Owner> toEntities() {
        return allOwners.stream()
                .map(OwnersGetOwnerResponse::toEntity)
                .collect(Collectors.toList());
    }
}
