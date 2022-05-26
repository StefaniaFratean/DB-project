package db.Gameez.repo;

import db.Gameez.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameRepo extends JpaRepository<Game, Long>{
    void getAllByGameId(Long gameId);





}
