package db.Gameez;

import db.Gameez.Service.GameService;
import db.Gameez.Service.UserService;
import db.Gameez.model.Game;
import db.Gameez.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class Controller {
  //  private final Game;

    private final GameService gameService;

    public Controller(GameService userService) {
        this.gameService = userService;
    }

    @GetMapping("/store")
    public ResponseEntity<List<Game>> getAllGames(){
        List<Game> games = gameService.findAllGames();
        return new ResponseEntity<>(games, HttpStatus.OK);
    }




}
