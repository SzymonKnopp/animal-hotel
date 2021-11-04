package s175550.animalhotel.webservices.animals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import s175550.animalhotel.owner.Owner;
import s175550.animalhotel.webservices.animals.dto.AnimalsCreateOwnerRequest;
import s175550.animalhotel.webservices.animals.dto.AnimalsUpdateOwnerRequest;
import s175550.animalhotel.owner.dto.UpdateOwnerRequest;

@Component
public class AnimalsRestClient {
    private final RestTemplate animalsWebserviceClient;

    @Autowired
    AnimalsRestClient(@Value("${animal-hotel.animals.url}") String animalsUrl) {
        animalsWebserviceClient = new RestTemplateBuilder().rootUri(animalsUrl).build();
    }

    public void createOwner(Owner owner) {
        animalsWebserviceClient.postForLocation("/owners", AnimalsCreateOwnerRequest.fromEntity(owner));
    }

    public void updateOwner(int id, UpdateOwnerRequest updateRequest) {
        animalsWebserviceClient.patchForObject(
            "/owners/" + id,
            AnimalsUpdateOwnerRequest.fromUpdateDto(updateRequest),
            void.class
        );
    }

    public void deleteOwner(int id) {
        animalsWebserviceClient.delete("/owners/" + id);
    }
}
