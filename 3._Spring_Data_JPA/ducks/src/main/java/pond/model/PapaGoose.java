package pond.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "papageese")
public class PapaGoose {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer age;

    @OneToMany(mappedBy = "sugarGoose")
    private List<Duck> ducks = new ArrayList<>();

    public void setDucks(List<Duck> ducks) {
        this.ducks = ducks;
    }

    public PapaGoose() {
    }

    public PapaGoose(Integer age) {
        this.age = age;
    }

    public List<Duck> getDucks() {
        return ducks;
    }
}
