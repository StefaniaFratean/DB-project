package db.Gameez.controller;

import db.Gameez.Service.UserService;
import db.Gameez.exception.UserNotFoundException;
import db.Gameez.model.User;
import db.Gameez.security.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class NavigationController {
    @Autowired
    private UserService userService;
    @GetMapping("/login")
    public String showLoginPage(final Principal principal) {
        if (principal != null)
            return "redirect:/";

        return "login";
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
    public String showStore() {
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
}
