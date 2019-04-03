package pond;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ponds")
public class Pond {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String location;

    @ManyToMany
    private Set<Duck> ducks;
}
