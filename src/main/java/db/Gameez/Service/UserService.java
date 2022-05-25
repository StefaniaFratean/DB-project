package db.Gameez.Service;

import db.Gameez.exception.UserNotFoundException;
import db.Gameez.model.Game;
import db.Gameez.model.User;
import db.Gameez.model.Wishlist;
import db.Gameez.repo.UserRepo;
import db.Gameez.repo.WishlistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepo userRepo;
    private final WishlistRepo wishlistRepo;

    @Autowired
    public UserService(UserRepo userRepo, WishlistRepo wishlistRepo) {
        this.userRepo = userRepo;
        this.wishlistRepo = wishlistRepo;
    }

    public User addUser(User user){
        //user.setEmail(UUID.randomUUID().toString());
        return userRepo.save(user);
    }

    public List<User> findAllUsers(){
        return userRepo.findAll();
    }

    public User updateUser(User user){
        return userRepo.save(user);
    }

    public User findUserById(Long id){
        return userRepo.findUserByUserId(id).orElseThrow(()-> new UserNotFoundException("User by id " + id +"was not found"));
    }

    public void deleteUser(Long id){
        userRepo.deleteUserByUserId(id);
    }


    public Optional<User> findByUsername(String userName) {
        return userRepo.findUserByUsername(userName);
    }

    public List<Game> getWishlist(User user) {
        final List<Wishlist> allByUser = wishlistRepo.findAllByUser(user);

        return allByUser.stream().map(Wishlist::getGame).collect(Collectors.toList());
    }
}
