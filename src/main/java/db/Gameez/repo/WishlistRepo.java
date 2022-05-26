package db.Gameez.repo;

import db.Gameez.model.Game;
import db.Gameez.model.User;
import db.Gameez.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface WishlistRepo extends JpaRepository<Wishlist, Long> {

    List<Wishlist> findAllByUser(User user);

    @Transactional
    void deleteByGameAndUser(Game game, User user);
}
