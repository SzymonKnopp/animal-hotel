package s175550.animalhotel.entities.owner.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import s175550.animalhotel.entities.owner.Owner;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ClientGetAllOwnersResponse {
    private final List<ClientGetOwnerResponse> allOwners;

    public List<Owner> toEntities() {
        return allOwners.stream()
                .map(ClientGetOwnerResponse::toEntity)
                .collect(Collectors.toList());
    }
}
