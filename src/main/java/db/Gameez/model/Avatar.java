package db.Gameez.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Avatar implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(nullable = false)
    private String photoPath;

    public Avatar() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    @Override
    public String toString() {
        return "Avatar{" +
                "id=" + id +
                ", photoPath='" + photoPath + '\'' +
                '}';
    }
}
