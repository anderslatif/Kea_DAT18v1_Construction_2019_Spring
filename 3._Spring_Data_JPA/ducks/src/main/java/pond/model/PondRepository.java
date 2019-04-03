package pond.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PondRepository extends CrudRepository<Pond, Integer> {
    List<Pond> findByLocation(String location);
}
