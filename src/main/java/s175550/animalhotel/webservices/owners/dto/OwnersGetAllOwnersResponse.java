package s175550.animalhotel.webservices.owners.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import s175550.animalhotel.entities.owner.Owner;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OwnersGetAllOwnersResponse {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class SimpleOwner {
        private int id;
        private String name;
        private String surname;

        public Owner toEntity() {
            return Owner.builder()
                    .id(id)
                    .name(name)
                    .surname(surname)
                    .build();
        }
    }

    private List<SimpleOwner> allOwners;

    public List<Owner> toEntities() {
        return allOwners.stream()
                .map(SimpleOwner::toEntity)
                .collect(Collectors.toList());
    }
}
