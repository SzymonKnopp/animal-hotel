package s175550.animalhotel.entities.owner;

import lombok.*;
import s175550.animalhotel.entities.animal.Animal;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString

@Entity
@Table(name = "owners")
public class Owner implements Serializable {
    @ToString.Exclude
    @Id
    private Integer id;

    private String name;

    private String surname;

    @ToString.Exclude
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    @Column(name = "owned_animals")
    private List<Animal> ownedAnimals;
}
