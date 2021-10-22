package s175550.animalhotel.entities.animal.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import s175550.animalhotel.entities.animal.Animal;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetAllAnimalsResponse {
    @AllArgsConstructor
    private static class SimpleAnimal {
        private final int id;
        private final String name;
    }

    private final List<SimpleAnimal> allAnimals;

    public static GetAllAnimalsResponse fromEntities(List<Animal> allAnimalEntities) {
        List<SimpleAnimal> allAnimals = allAnimalEntities.stream()
                .map(animalEntity -> new SimpleAnimal(
                        animalEntity.getId(),
                        animalEntity.getName()
                ))
                .collect(Collectors.toList());

        return new GetAllAnimalsResponse(allAnimals);
    }
}
