package com.example.oidctest;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/userinfo")
    public String userinfo(Model model, @AuthenticationPrincipal OidcUser oidcUser) {
        model.addAttribute("user", oidcUser);
        return "userinfo";
    }
}
