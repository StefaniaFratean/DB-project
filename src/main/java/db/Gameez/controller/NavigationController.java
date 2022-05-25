package db.Gameez.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class NavigationController {
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
    public String showWishlist() {
        return "wishlist";
    }

    @GetMapping("/index")
    public String showIndex() {
        return "index";
    }
}
