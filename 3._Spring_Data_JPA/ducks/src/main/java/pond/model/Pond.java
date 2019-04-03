package pond.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ponds")
public class Pond {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String location;

    @ManyToMany(mappedBy = "favoritePonds")
    private Set<Duck> ducks = new HashSet<>();


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<Duck> getDucks() {
        return ducks;
    }

    public void setDucks(Set<Duck> ducks) {
        this.ducks = ducks;
    }
}
