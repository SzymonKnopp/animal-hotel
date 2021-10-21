package s175550.animalhotel.entities.owner.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import s175550.animalhotel.entities.owner.Owner;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetAllOwnersResponse {
    @AllArgsConstructor
    private static class SimpleOwner {
        private final String name;
        private final String surname;
    }

    private final List<SimpleOwner> allOwners;

    public static GetAllOwnersResponse fromEntities(List<Owner> allOwnerEntities) {
        List<SimpleOwner> allOwners = allOwnerEntities.stream()
                .map(ownerEntity -> new SimpleOwner(
                        ownerEntity.getName(),
                        ownerEntity.getSurname()
                ))
                .collect(Collectors.toList());

        return new GetAllOwnersResponse(allOwners);
    }
}
