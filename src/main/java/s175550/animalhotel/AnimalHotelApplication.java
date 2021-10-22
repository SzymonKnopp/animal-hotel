package s175550.animalhotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("s175550.animalhotel.entities.owner")
public class AnimalHotelApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnimalHotelApplication.class, args);

    }

}
