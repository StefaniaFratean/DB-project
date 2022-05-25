package db.Gameez.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "avatar")
public class Avatar implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long avatarId;
    @Column(nullable = false)
    private String photoPath;

    public Avatar() {
    }

    public Long getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(Long id) {
        this.avatarId = id;
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
                "id=" + avatarId +
                ", photoPath='" + photoPath + '\'' +
                '}';
    }
}
