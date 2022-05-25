package db.Gameez.repo;

import db.Gameez.model.Avatar;
import db.Gameez.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepo extends JpaRepository<Category, Long> {



}
