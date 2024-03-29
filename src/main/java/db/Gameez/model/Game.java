package db.Gameez.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "games")
public class Game implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long gameId;
    @Column (nullable = false)
    private String name;
    private String description;
    @Column (nullable = false)
    private double price;
    @Column (nullable = false)
    private  String requirements;
    @ManyToOne
    @JoinColumn(name = "producer_id")
    private Producer producer;
    private int size;
    private String file;

    public Game() {
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long id) {
        this.gameId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getFile() {
        return file;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public void setFile(String filePath) {
        this.file = filePath;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + gameId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", requirements='" + requirements + '\'' +
                ", size=" + size +
                ", filePath='" + file + '\'' +
                '}';
    }
}
