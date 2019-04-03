package pond;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ducks")
public class Duck {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "ducks_ponds",
            joinColumns = @JoinColumn(name = "duck_id"),
            inverseJoinColumns = @JoinColumn(name = "pond_id")
    )
    private Set<Pond> favoritePonds;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
