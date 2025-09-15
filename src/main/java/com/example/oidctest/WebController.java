package com.example.oidctest;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class WebController {
    @GetMapping("/userinfo")
    public String userinfo(Model model, @AuthenticationPrincipal OidcUser oidcUser) {
        if (oidcUser != null) {
            model.addAttribute("user", Map.of(
                "name", oidcUser.getFullName(),
                "email", oidcUser.getEmail(),
                "claims", oidcUser.getClaims()
            ));
        }
        return "userinfo";
    }
}
