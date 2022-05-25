package db.Gameez.repo;

import db.Gameez.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    void deleteUserByUserId(Long id);

    Optional<User> findUserByUserId(Long id);


}
