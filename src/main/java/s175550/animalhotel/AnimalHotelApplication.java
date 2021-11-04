package s175550.animalhotel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AnimalHotelApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnimalHotelApplication.class, args);
    }

    @Bean
    public RouteLocator routeLocator(
            RouteLocatorBuilder builder,
            @Value("${server.port}") Integer port,
            @Value("${animal-hotel.owners.url}") String ownersUrl,
            @Value("${animal-hotel.animals.url}") String animalsUrl
    ) {
        return builder.routes()
                .route("owners", route -> route.host("localhost:" + port)
                        .and()
                        .path("/api/owners", "/api/owners/**")
                        .uri(ownersUrl))
                .route("animals", route -> route.host("localhost:" + port)
                        .and()
                        .path("/api/animals", "/api/animals/**")
                        .uri(animalsUrl))
                .build();
    }
}
