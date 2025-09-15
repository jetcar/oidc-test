package com.example.oidctest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ErrorController {
    @GetMapping("/error")
    public String errorPage(@RequestParam(value = "error", required = false) String error, Model model) {
        model.addAttribute("error", error != null ? error : "An error occurred.");
        return "error";
    }
}
