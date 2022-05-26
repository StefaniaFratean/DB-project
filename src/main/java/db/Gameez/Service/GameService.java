package db.Gameez.Service;

import db.Gameez.exception.GameNotFoundException;
import db.Gameez.model.Game;
import db.Gameez.model.User;
import db.Gameez.model.Wishlist;
import db.Gameez.repo.GameRepo;
import db.Gameez.repo.WishlistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GameService {
    private final GameRepo gameRepo;
    private final WishlistRepo wishlistRepo;


    @Autowired
    public GameService(GameRepo gameRepo, WishlistRepo wishlistRepo) {
        this.gameRepo = gameRepo;
        this.wishlistRepo = wishlistRepo;
    }

    public List<Game> findAllGames(){
        return gameRepo.findAll();
    }

    public Game findById(long id){
        return gameRepo.findById(id).orElseThrow(() -> new GameNotFoundException("Game not found!"));
    }



}
