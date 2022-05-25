package db.Gameez.repo;

import db.Gameez.model.Purchases;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchasesRepo extends JpaRepository<Purchases, Long> {
}
