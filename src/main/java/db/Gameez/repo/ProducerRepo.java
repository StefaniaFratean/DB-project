package db.Gameez.repo;

import db.Gameez.model.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProducerRepo extends JpaRepository<Producer, Long> {
}
