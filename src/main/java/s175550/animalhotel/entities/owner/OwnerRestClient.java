package s175550.animalhotel.entities.owner;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import s175550.animalhotel.entities.owner.dto.ClientGetAllOwnersResponse;
import s175550.animalhotel.entities.owner.dto.GetOwnerResponse;

import java.util.Optional;

@Component
public class OwnerRestClient {
    private final RestTemplate ownerRest;

    @Autowired
    OwnerRestClient(@Value("${animal-hotel.owners.url") String ownersUrl) {
        this.ownerRest = new RestTemplateBuilder().rootUri(ownersUrl).build();
    }

    public ClientGetAllOwnersResponse getAllOwners() {
        ResponseEntity<ClientGetAllOwnersResponse> response =
                ownerRest.getForEntity("/owners", ClientGetAllOwnersResponse.class);
        return response.getBody();
    }

    public Optional<GetOwnerResponse> getOwnerById(int id) {
        ResponseEntity<GetOwnerResponse> response =
                ownerRest.getForEntity("/" + id, GetOwnerResponse.class);
        return Optional.ofNullable(response.getBody());
    }
}
