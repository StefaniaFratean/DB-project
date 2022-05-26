package db.Gameez.repo;

import db.Gameez.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    void deleteUserByUserId(Long id);

    Optional<User> findUserByUserId(Long id);

    Optional<User> findUserByUsername(String username);



}
