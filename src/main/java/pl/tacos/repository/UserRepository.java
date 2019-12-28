package pl.tacos.repository;

import org.springframework.data.repository.CrudRepository;
import pl.tacos.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

}

