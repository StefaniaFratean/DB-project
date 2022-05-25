package db.Gameez.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "purchases")
public class Purchases implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long purchasesId;
    @Column(nullable = false)
    private Long userId;
    @Column(nullable = false)
    private Long gameId;

    public Purchases() {
    }

    public Long getPurchasesId() {
        return purchasesId;
    }

    public void setPurchasesId(Long id) {
        this.purchasesId = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    @Override
    public String toString() {
        return "Purchases{" +
                "id=" + purchasesId +
                ", userId=" + userId +
                ", gameId=" + gameId +
                '}';
    }
}
