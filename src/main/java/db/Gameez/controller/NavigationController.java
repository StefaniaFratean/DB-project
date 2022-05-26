package db.Gameez.controller;

import db.Gameez.Service.GameService;
import db.Gameez.Service.UserService;
import db.Gameez.exception.UserNotFoundException;
import db.Gameez.model.Game;
import db.Gameez.model.User;
import db.Gameez.model.Wishlist;
import db.Gameez.repo.WishlistRepo;
import db.Gameez.security.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class NavigationController {
    @Autowired
    private UserService userService;
    @Autowired
    private GameService gameService;

    @Autowired
    private WishlistRepo wishlistRepo;
    @GetMapping("/login")
    public String showLoginPage(final Principal principal) {
        if (principal != null)
            return "redirect:/";

        return "login";
    }

    @GetMapping("/register")
    public String showRegisterPage(final Principal principal) {
        if (principal != null)
            return "redirect:/";

        return "register";
    }


    @GetMapping("/settings")
    public String showSettings() {
        return "settings";
    }

    @GetMapping("/about")
    public String showAbout() {
        return "about";
    }

    @GetMapping("/wallet")
    public String showWallet() {
        return "wallet";
    }

    @GetMapping("/store")
    public String showStore(Model model) {
        UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        final User user = userService.findByUsername(userDetails.getUsername()).orElseThrow(() -> new UserNotFoundException("not found"));
        model.addAttribute("user", user);
        model.addAttribute("store", userService.getGames());
        return "store";
    }


    @GetMapping("/wishlist")
    public String showWishlist(Model model) {
        UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        final User user = userService.findByUsername(userDetails.getUsername()).orElseThrow(() -> new UserNotFoundException("not found"));
        model.addAttribute("user", user);
        model.addAttribute("wishlist", userService.getWishlist(user));
        return "wishlist";
    }

    @GetMapping("/index")
    public String showIndex() {
        return "index";
    }

//    @PostMapping
//    public void registerNewUser(Model model) {
//        UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        final User user = userService.findByUsername(userDetails.getUsername()).orElseThrow(() -> new UserNotFoundException("not found"));
//        model.addAttribute("user", user);
//        userService.addNewUser(user);
//    }


    @PostMapping(value = "/addWish", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addWish(Model model, HttpServletRequest request) {
        final Map<String, String[]> parameterMap = request.getParameterMap();
        UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        final User user = userService.findByUsername(userDetails.getUsername()).orElseThrow(() -> new UserNotFoundException("not found"));
        final long gameId = Long.parseLong(parameterMap.get("gameId")[0]);
        final Game game = gameService.findById(gameId);
        Wishlist newWish = new Wishlist();
        newWish.setUser(user);
        newWish.setGame(game);
        wishlistRepo.saveAndFlush(newWish);

        model.addAttribute("user", user);
        model.addAttribute("wishlist", userService.getWishlist(user));
        return "wishlist";
    }


}
