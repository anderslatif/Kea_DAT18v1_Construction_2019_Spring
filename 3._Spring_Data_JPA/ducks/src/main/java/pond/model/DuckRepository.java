package pond.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DuckRepository extends CrudRepository<Duck, Long> {
    List<Duck> findByName(String name);
}
