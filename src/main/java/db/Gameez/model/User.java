package db.Gameez.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false, name="userId")
    private Long userId;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    private String name;
    @Column(nullable = false)
    private double wallet;
    private String email;
    private String avatarId;

    public User() {
    }

    public User(String username, String password, String name, double wallet, String email, String avatarId) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.wallet = wallet;
        this.email = email;
        this.avatarId = avatarId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(String avatarId) {
        this.avatarId = avatarId;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", wallet=" + wallet +
                ", email='" + email + '\'' +
                ", avatarId=" + avatarId +
                '}';
    }
}
