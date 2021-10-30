package s175550.animalhotel.owner.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import s175550.animalhotel.owner.Owner;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetAllOwnersResponse {
    @Getter
    @AllArgsConstructor
    private static class SimpleOwner {
        private final int id;
        private final String name;
        private final String surname;
    }

    private final List<SimpleOwner> allOwners;

    public static GetAllOwnersResponse fromEntities(List<Owner> allOwnerEntities) {
        List<SimpleOwner> allOwners = allOwnerEntities.stream()
                .map(ownerEntity -> new SimpleOwner(
                        ownerEntity.getId(),
                        ownerEntity.getName(),
                        ownerEntity.getSurname()
                ))
                .collect(Collectors.toList());

        return new GetAllOwnersResponse(allOwners);
    }
}
