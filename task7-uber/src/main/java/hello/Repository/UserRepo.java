package hello.Repository;

import org.springframework.data.repository.CrudRepository;
import hello.Entities.Users;

import java.util.List;


public interface UserRepo extends CrudRepository<Users, Long> {
    List<Users> findByUsername(String username);
}
