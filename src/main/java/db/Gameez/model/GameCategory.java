package db.Gameez.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "games_has_categories")
public class GameCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @ManyToOne
    private Category category;
    @ManyToOne
    private Game game;

    public GameCategory() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public String toString() {
        return "GameHasCategory{" ;
    }
}
