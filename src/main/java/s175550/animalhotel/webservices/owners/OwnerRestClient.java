package s175550.animalhotel.webservices.owners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import s175550.animalhotel.webservices.owners.dto.OwnersGetAllOwnersResponse;

@Component
public class OwnerRestClient {
    private final RestTemplate ownerRest;

    @Autowired
    OwnerRestClient(@Value("${animal-hotel.owners.url}") String ownersUrl) {
        this.ownerRest = new RestTemplateBuilder().rootUri(ownersUrl).build();
    }

    public OwnersGetAllOwnersResponse getAllOwners() {
        ResponseEntity<OwnersGetAllOwnersResponse> response =
                ownerRest.getForEntity("/owners", OwnersGetAllOwnersResponse.class);
        return response.getBody();
    }
}
