package com.example.oidctest;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class WebController {
    @GetMapping("/userinfo")
    public String userinfo(Model model, @AuthenticationPrincipal OidcUser oidcUser) {
        if (oidcUser != null) {
            java.util.Map<String, Object> user = new java.util.HashMap<>();
            user.put("givenname", oidcUser.getClaimAsString("givenname"));
            user.put("surname", oidcUser.getClaimAsString("surname"));
            user.put("personal_code", oidcUser.getClaimAsString("sub"));
            user.put("phone_number", oidcUser.getClaimAsString("phone_number")); // may be null, HashMap allows it
            user.put("date_of_birth", oidcUser.getClaimAsString("date_of_birth"));
            user.put("claims", oidcUser.getClaims());
            model.addAttribute("user", user);
        }
        return "userinfo";
    }
}
