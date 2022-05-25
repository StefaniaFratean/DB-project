package db.Gameez.repo;

import db.Gameez.model.GameCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameCategoryRepo extends JpaRepository<GameCategory, Long> {
}
