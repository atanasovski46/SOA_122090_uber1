package feedback.Repository;

import org.springframework.data.repository.CrudRepository;
import feedback.Entities.Stars;


public interface StarsRepository extends CrudRepository<Stars, Long>
{
       // void get
}
