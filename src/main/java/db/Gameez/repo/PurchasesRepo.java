package db.Gameez.repo;

import db.Gameez.model.Game;
import db.Gameez.model.Purchases;
import db.Gameez.model.User;
import db.Gameez.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PurchasesRepo extends JpaRepository<Purchases, Long> {

    List<Purchases> findAllByUser(User user);
}
