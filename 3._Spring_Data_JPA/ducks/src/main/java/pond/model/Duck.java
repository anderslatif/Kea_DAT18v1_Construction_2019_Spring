package pond.model;

import pond.model.Pond;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
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
    private Set<Pond> favoritePonds = new HashSet<>();

    public Set<Pond> getFavoritePonds() {
        return favoritePonds;
    }

    public void setFavoritePonds(Set<Pond> favoritePonds) {
        this.favoritePonds = favoritePonds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
