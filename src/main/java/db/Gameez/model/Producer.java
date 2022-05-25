package db.Gameez.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "producer")
public class Producer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long producerId;

    @Column(nullable = false)
    private String name;

    private String description;

    public Producer() {
    }

    public Long getProducerId() {
        return producerId;
    }

    public void setProducerId(Long id) {
        this.producerId = id;
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

    @Override
    public String toString() {
        return "Producer{" +
                "id=" + producerId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
